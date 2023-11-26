package Task1;

import java.util.Arrays;
import java.util.Stack;

public class MyLIFO_App {
		// This method reserves the given array
		public static <E> void reserve(E[] array) {
		int start = 0;
		int end = array.length - 1;
		while (start < end) {
			E temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		}
		// This method checks the correctness of the given input
		// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
		public static boolean isCorrect(String input) {
	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < input.length(); i++) {
		char ch = input.charAt(i);
		if (ch == '(' || ch == '{' || ch == '[') {
			stack.push(ch);
			if (stack.isEmpty()) {
				return false;
			}
			char top = stack.pop();
			if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
				return false;
			}
		}
	}
		return stack.isEmpty();
		}
		// This method evaluates the value of an expression
		// i.e. 51 + (54 *(3+2)) = 321
		public static Double evaluateExpression(String
		expression) {
		Stack<Double> operandStack = new Stack<>();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                // Extract the operand
                double operand = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    operand = operand * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                if (i < expression.length() && expression.charAt(i) == '.') {
                    i++;
                    double fraction = 0.1;
                    while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                        operand += (expression.charAt(i) - '0') * fraction;
                        fraction *= 0.1;
                        i++;
                    }
                }
                i--; // Move back by one position to correctly process the next character
                operandStack.push(operand);
            } else if (ch == '(') {
                // Push opening parenthesis to operatorStack
                stack.push(ch);
            } else if (ch == ')') {
                // Process operators within parentheses
                while (stack.peek() != '(') {
                    evaluateTopOperator(operandStack, stack);
                }
                stack.pop(); // Pop the opening parenthesis
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Process operators with higher or equal precedence
                while (!stack.isEmpty() && hasHigherOrEqualPrecedence(ch, stack.peek())) {
                    evaluateTopOperator(operandStack, stack);
                }
                stack.push(ch);
            }
        }

        // Process remaining operators
        while (!stack.isEmpty()) {
            evaluateTopOperator(operandStack, stack);
        }

        // The final result is the top of the operandStack
        return operandStack.pop();
    }

    private static void evaluateTopOperator(Stack<Double> operandStack, Stack<Character> operatorStack) {
        char operator = operatorStack.pop();
        double operand2 = operandStack.pop();
        double operand1 = operandStack.pop();
        double result = performOperation(operand1, operand2, operator);
        operandStack.push(result);
    }

    private static boolean hasHigherOrEqualPrecedence(char operator1, char operator2) {
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return true;
        }
        return false;
    }

    private static double performOperation(double operand1, double operand2, char operator) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
public static void main(String[] args) {
	Integer[] array = {1,2,3,4,5};
	MyLIFO_App.reserve(array);
	System.out.println(Arrays.toString(array));
	
	String input1 = "()(())[]{(())]";
	boolean isCorrect1 = MyLIFO_App.isCorrect(input1);
	System.out.println(isCorrect1);
	
	String e = "18 + (2 * 2 - 1) / (1 + 3)";
	double result = evaluateExpression(e);
	System.out.println(result)                         ;
}
}
