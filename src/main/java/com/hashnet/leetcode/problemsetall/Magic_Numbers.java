package com.hashnet.leetcode.problemsetall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Magic_Numbers {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String[] range = in.readLine().split("\\s+");
        int a = Integer.parseInt(range[0]);
        int b = Integer.parseInt(range[1]);

        boolean foundMadic = false;
        for (int i = a; i <= b; i++) {
            if (isMagic(i)) {
                foundMadic = true;
                System.out.println(i);
            }
        }

        if (!foundMadic) {
            System.out.println("-1");
        }
    }

    /**
     * Convert the number to an array of digits and checks uniqueness and proper order of unique visits
     */
    private static boolean isMagic(int num) {
        if (num < 10) {
            return true;
        }

        char[] chars = String.valueOf(num).toCharArray();
        int[] numbers = new int[chars.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = chars[i] - '0';
        }

        if (!isUnique(numbers)) {
            return false;
        }

        if (!isVistedCorrectly(numbers)) {
            return false;
        }

        return true;
    }

    /**
     * Check if all the digits are unique
     */
    private static boolean isUnique(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            if (set.contains(number)) {
                return false;
            }

            set.add(number);
        }

        return true;
    }

    /**
     * Check if all the positions are visited and position 0 is visited at the last step
     */
    private static boolean isVistedCorrectly(int[] numbers) {
        Set<Integer> positions = new HashSet<>();

        int position = 0;
        int jump = numbers[0];
        for (int i = 1; i <= numbers.length; i++) {
            position = (position + jump) % numbers.length;

            if (i < numbers.length && position == 0) {
                return false;
            }
            if (positions.contains(position)) {
                return false;
            }

            positions.add(position);
            jump = numbers[position];
        }

        return true;
    }
}