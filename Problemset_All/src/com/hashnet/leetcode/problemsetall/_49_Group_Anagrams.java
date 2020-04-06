package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class _49_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] chArr = str.toCharArray();
            Arrays.sort(chArr);
            String sortedStr = String.valueOf(chArr);

            List<String> list = map.get(sortedStr);
            if(list == null) {
                List<String> newList = new ArrayList<>();
                newList.add(str);

                map.put(sortedStr, newList);
                res.add(newList);
            } else {
                list.add(str);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        _49_Group_Anagrams solution = new _49_Group_Anagrams();

        System.out.println(solution.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
