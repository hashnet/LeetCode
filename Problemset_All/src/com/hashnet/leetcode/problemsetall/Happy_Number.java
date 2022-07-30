package com.hashnet.leetcode.problemsetall;

import java.util.HashSet;
import java.util.Set;

public class Happy_Number {
	public static void main(String[] args) {
		Happy_Number s = new Happy_Number();
		System.out.println(s.isHappy(1));
		System.out.println(s.isHappy(19));
		System.out.println(s.isHappy(55));
		
	}
	
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while(n != 1) {
        	String s = String.valueOf(n);
        	int sum = 0;
        	while(n > 0) {
        		int num = n%10;
        		sum += num * num;
        		n = n /10;
        	}
        	
        	n = sum;
        	if(set.contains(n)) return false;
        	set.add(n);
        }
        
        return true;
    }
}
