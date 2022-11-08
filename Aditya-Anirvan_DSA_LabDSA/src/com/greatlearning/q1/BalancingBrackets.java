package com.greatlearning.q1;
import java.util.*;

public class BalancingBrackets {
	private static boolean balancebrackets(String a) {
		Stack<Character> bracket = new Stack<Character>();
		for(int i = 0;i<a.length();i++) {
			char c = a.charAt(i);
			if(c == '{' ||c == '('||c == '[')
				bracket.push(c);
			if(bracket.isEmpty()) return false;
			if(c == '}' ||c == ')'||c == ']') {
				char top = bracket.peek();
				switch(c) {
				case'}' : 
					if(top=='{') bracket.pop();
					break;
				case']' : 
					if(top=='[') bracket.pop();
					break;
				case')' : 
					if(top=='(') bracket.pop();
					break;
				}
			}
		}
		if(bracket.isEmpty()) return true;
		return false;
	}
	public static void main(String[] args) {
		String brackets = "[[]]";
		boolean isbalanced = balancebrackets(brackets);
		if(isbalanced)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");
	}

}
