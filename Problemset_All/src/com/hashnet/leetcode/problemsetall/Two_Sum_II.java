package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Two_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;

        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target) return new int[]{i+1, j+1};

            if(sum < target) ++i;
            if(sum > target) --j;
        }

        return null;
    }

    public static void main(String[] args) {
        Two_Sum_II solution = new Two_Sum_II();

        System.out.println(ArrayUtility.int1DArrayToString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}