package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Combination_Sum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        recurse(0, candidates, target, new ArrayDeque<>(), result);

        return result;
    }

    private void recurse(int index, int[] candidates, int target, Deque<Integer> currList, List<List<Integer>> result) {
        if(target < 0) return;

        if(target == 0) result.add(new ArrayList<>(currList));

        for(int i=index; i<candidates.length; i++) {
            if (candidates[i] > target) break;

            currList.push(candidates[i]);
            recurse(i, candidates, target-candidates[i], currList, result);
            currList.pop();
        }
    }

    public static void main(String[] args) {
        Combination_Sum2 solution = new Combination_Sum2();

        System.out.println(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,5}, 8));
    }
}
