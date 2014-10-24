package com.ding;

import java.util.Stack;


public class Syntax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Syntax syntax = new Syntax();
		boolean ret1 = syntax.match("()");
		System.out.print(ret1);
		boolean ret2 = syntax.match("x(y(z{test})abc)");
		System.out.print(ret2);
		
		boolean ret3 = syntax.match("([)]");
		System.out.print(ret3);
		
		boolean ret4 = syntax.match("[[]](()){{{}}}");
		System.out.print(ret4);
		
		boolean ret5 = syntax.match("abc(def(ghi)");
		System.out.print(ret5);

	}
	
	public boolean match(String input){
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i < input.length(); ++i){
			char currentChar = input.charAt(i);
			if(currentChar=='(' || currentChar=='[' || currentChar=='{'){
				stack.push(currentChar);
			}
			else if(currentChar==')'){
				Character stackChar = stack.pop();
				if(stackChar!='(')
					return false;
			}
			else if(currentChar==']'){
				Character stackChar = stack.pop();
				if(stackChar!='[')
					return false;
			}
			if(currentChar=='}'){
				Character stackChar = stack.pop();
				if(stackChar!='{')
					return false;
			}
		}
		
		if(stack.empty())
			return true;
		
		return false;
	}

}
