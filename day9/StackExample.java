package com.celcom.day9;


import java.util.Collections;
import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		
		stack.push(12);
		stack.push(2);
		stack.push(44);
		stack.push(211);
		stack.push(33);
		System.out.println(stack);
		
		stack.pop();
		
		System.out.println(stack);
		System.out.println(stack.peek());
		stack.add(3);
		stack.remove(0);
		System.out.println(stack);
		Collections.reverse(stack);;
	
		System.out.println(stack);
		
	}

}
