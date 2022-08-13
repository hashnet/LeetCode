package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Roman_to_Integer {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        int i = 0;
        while (i < s.length()) {
            if (((i + 1) < s.length()) && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))) {
                result += (map.get(s.charAt(i + 1)) - map.get(s.charAt(i)));

                i += 2;
            } else {
                result += map.get(s.charAt(i));

                i += 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Roman_to_Integer solution = new Roman_to_Integer();

        System.out.println(solution.romanToInt("I"));
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}
