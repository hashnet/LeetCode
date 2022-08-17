package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.PrintUtility;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary {

    public int numWays(String[] words, String target) {
        List<Map<Character, Integer>> countMaps = buildCountMaps(words);

        return dp(words[0].length() - 1, target.length() - 1, words, target, countMaps);
    }

    public int dp(int dictIndex, int targetIndex, String[] words, String target,
        List<Map<Character, Integer>> countMaps) {
        int multiplier = countMaps.get(dictIndex).getOrDefault(target.charAt(targetIndex), 0);
        if (targetIndex == 0) {
            return multiplier;
        } else {
            int sum = 0;
            for (int i = dictIndex; i >= targetIndex; i--) {
                sum += dp(i - 1, targetIndex - 1, words, target, countMaps);
            }
            return sum * multiplier;
        }
    }

    private List<Map<Character, Integer>> buildCountMaps(String[] words) {
        int len = words[0].length();

        List<Map<Character, Integer>> countMaps = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            countMaps.add(new HashMap<>());
        }

        Arrays.stream(words).forEach(word -> {
            for (int i = 0; i < len; i++) {
                countMaps.get(i).compute(word.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
        });

        return countMaps;
    }

    public static void main(String[] args) {
        Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary solution = new Number_of_Ways_to_Form_a_Target_String_Given_a_Dictionary();

        System.out.println(solution.numWays(new String[]{"acca", "bbbb", "caca"}, "aba"));
        System.out.println(solution.numWays(new String[]{"abba", "baab"}, "bab"));
    }
}
