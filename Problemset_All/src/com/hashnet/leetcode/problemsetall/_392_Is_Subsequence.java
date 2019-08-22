package com.hashnet.leetcode.problemsetall;

public class _392_Is_Subsequence {
	public boolean isSubsequence(String s, String t) {
		if(s.length() == 0) return true;
        
        int j = 0;
        
        for(int i=0; i<t.length(); i++) {
        	if(t.charAt(i) == s.charAt(j)) ++j;
        	
        	if(j >= s.length()) return true;
        }
        
        if(j >= s.length()) return true;
        else return false;        
    }
	
	public static void main(String[] args) {
		_392_Is_Subsequence solution = new _392_Is_Subsequence();
		
		System.out.println(solution.isSubsequence("abc", "ahbgdcd"));
		System.out.println(solution.isSubsequence("axc", "ahbgdc"));
	}
}
