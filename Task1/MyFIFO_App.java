package Task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
	 Queue<E> temp = new LinkedList<>();
     while (!input.isEmpty()){
         temp.add(input.peek());
         temp.add(input.poll());
     }
     input.addAll(temp);
	}
	// Method mirror that accepts a queue of strings as a parameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		  Stack<E> temp = new Stack<>();
	        Queue<E> result = new LinkedList<>(input);
	        while (!input.isEmpty()){
	            temp.add(input.poll());
	        }
	        while (!temp.isEmpty()){
	            result.add(temp.pop());
	        }
	        while (!result.isEmpty()){
	            input.add(result.poll());
	        }
	    
	}
	public static void main(String[] args) {
		//Test stutter
		Queue<Integer> i = new LinkedList<>();
		i.offer(1);
		i.offer(2);
		i.offer(3);
		MyFIFO_App.stutter(i);
		System.out.println(i);
		
		//Test mirror
		Queue<String> s = new LinkedList<>();
		s.offer("a");
		s.offer("b");
		s.offer("c");
		MyFIFO_App.mirror(s);
		System.out.println(s);
		
	}
}
