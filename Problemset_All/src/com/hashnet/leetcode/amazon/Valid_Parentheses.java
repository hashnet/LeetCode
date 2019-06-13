package com.hashnet.leetcode.amazon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Valid_Parentheses {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		
		Set<Character> start = new HashSet<>();
		start.add('(');
		start.add('{');
		start.add('[');
		
		Map<Character, Character> table = new HashMap<>();
		table.put(')', '(');
		table.put('}', '{');
		table.put(']', '[');
		
		Set<Character> end = table.keySet();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if(start.contains(c)) stack.push(c);
			else if(end.contains(c)) {
				char req = table.get(c);
				
				if(stack.isEmpty() || stack.pop() != req) return false;
			} else {
				continue;
			}
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}

	public static void main(String[] args) {
		Valid_Parentheses solution = new Valid_Parentheses();
		
		System.out.println(solution.isValid("()"));
		System.out.println(solution.isValid("()[]{}"));
		System.out.println(solution.isValid("(]"));
		System.out.println(solution.isValid("([)]"));
		System.out.println(solution.isValid("{[]}"));
	}
}
