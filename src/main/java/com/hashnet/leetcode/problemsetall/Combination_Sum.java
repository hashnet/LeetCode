package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Combination_Sum {

    private static List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        Deque<Integer> stack = new ArrayDeque<>();
        result = new ArrayList<>();
        recurse(0, candidates, target, 0, stack);

        return result;
    }

    private void recurse(int pos, int[] candidates, int target, int currSum, Deque<Integer> stack) {
        for(int i=pos; i<candidates.length; i++) {
            int sum = currSum + candidates[i];

            if(sum > target) break;

            if(sum == target) {
                stack.push(candidates[i]);
                result.add(new ArrayList<>(stack));
                stack.pop();
            }

            if(sum < target) {
                stack.push(candidates[i]);
                recurse(i, candidates, target, sum, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        Combination_Sum solution = new Combination_Sum();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,5}, 8));
    }
}
