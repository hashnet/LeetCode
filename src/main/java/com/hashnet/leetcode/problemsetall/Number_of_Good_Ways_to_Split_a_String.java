package com.hashnet.leetcode.problemsetall;

import java.util.HashSet;
import java.util.Set;

public class Number_of_Good_Ways_to_Split_a_String {
    public int numSplits(String s) {
        int arrLen = s.length()-1;
        int[] leftArr = new int[arrLen];
        int[] rightArr = new int[arrLen];

        Set<Character> leftSet = new HashSet<>();
        for(int i=0; i<leftArr.length; i++) {
            leftSet.add(s.charAt(i));
            leftArr[i] = leftSet.size();
        }

        Set<Character> rightSet = new HashSet<>();
        for(int i=rightArr.length-1; i>=0; i--) {
            rightSet.add(s.charAt(i+1));
            rightArr[i] = rightSet.size();
        }

        int result = 0;
        for(int i=0; i<s.length()-1; i++) {
            if(leftArr[i] == rightArr[i]) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Number_of_Good_Ways_to_Split_a_String solution = new Number_of_Good_Ways_to_Split_a_String();

        System.out.println(solution.numSplits("aacaba"));
        System.out.println(solution.numSplits("abcd"));
    }

}
