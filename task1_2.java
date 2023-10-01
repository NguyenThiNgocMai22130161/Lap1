package tast_1;

public class task1_2 {
//	Task 1.2: Using recursive approach to implement Fibonacci problem. Note, 
//	Fibonacci - next number is the sum of previous two numbers. 
//	Example: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, …
		//get the nth value of the Fibonacci series
		public static int getFibonacci(int n) {
		if (n <= 1) { //bỏ qua 2 số đầu là 0 ,1
			 return n;
		 } else {
			// tính các số Fibonacci dựa trên tổng của hai số trước đó
			 return getFibonacci(n - 1) + getFibonacci(n - 2);
			        }
			    }
		
		// This method is used to display a Fibonaccci series based on 
		//the parameter n. Ex. n=10 ==> 0 1 1 2 3 5 8 13 21 34
		public static void printFibonacci(int n) {
		//TODO
			System.out.print("Với n = " + n + " Output : ");
	        for (int i = 0; i < n; i++) {
	            System.out.print(getFibonacci(i) + " ");
	        }
	        System.out.println();
	    
		}
		public static void main(String[] args) {
			//test với n = 5
			int n = 5; // output = 2 + 3
	        int f1 = getFibonacci(n);
	        System.out.println("Với n = " + n + " thì Fibonacci trả về là: " + f1);
			
	        int terms = 5; 
	        printFibonacci(terms);
		}
			

}