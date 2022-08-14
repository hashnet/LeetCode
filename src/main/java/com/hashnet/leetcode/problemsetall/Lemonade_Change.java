package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

import java.util.HashMap;
import java.util.Map;

public class Lemonade_Change {
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                ++fives;
            } else if (bills[i] == 10) {
                if (fives >= 1) {
                    --fives;
                    ++tens;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if (tens >= 1 && fives >= 1) {
                    --tens;
                    --fives;
                } else if (fives >= 3) {
                    fives -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Lemonade_Change solution = new Lemonade_Change();

        System.out.println(solution.lemonadeChange(ArrayUtility.toIntArray(5, 5, 5, 10, 20)));
        System.out.println(solution.lemonadeChange(ArrayUtility.toIntArray(5, 5, 10, 10, 20)));
    }
}
