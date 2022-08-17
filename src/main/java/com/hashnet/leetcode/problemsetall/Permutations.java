package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;
import com.hashnet.leetcode.utility.PrintUtility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toList());

        permute(numsList, 0, len - 1, result);

        return result;
    }

    private void permute(List<Integer> nums, int level, int maxLevel, List<List<Integer>> result) {
        if (level == maxLevel) {
            result.add(new ArrayList<>(nums));
        }

        for (int i=level; i<=maxLevel; i++) {
            swap(nums, level, i);
            permute(nums, level + 1,  maxLevel, result);
            swap(nums, level, i);
        }

    }

    private void swap(List<Integer> list, int pos1, int pos2) {
        if (pos1 == pos2) return;

        Integer temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }

    public static void main(String[] args) {
        Permutations solution = new Permutations();

        System.out.println(PrintUtility.prettyPrint(solution.permute(ArrayUtility.toIntArray(1,2,3))));
        System.out.println(PrintUtility.prettyPrint(solution.permute(ArrayUtility.toIntArray(0,1))));
        System.out.println(PrintUtility.prettyPrint(solution.permute(ArrayUtility.toIntArray(1))));
    }
}
