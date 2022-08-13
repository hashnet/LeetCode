package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

import java.util.ArrayList;
import java.util.List;

public class Fruit_Into_Baskets {
    private static class Pair {
        private int val;
        private int count;

        public Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", val, count);
        }
    }

    public int totalFruit(int[] tree) {
        List<Pair> pairs = new ArrayList<>();
        int num = tree[0];
        int count = 1;
        for (int i = 1; i < tree.length; i++) {
            if (num != tree[i]) {
                pairs.add(new Pair(num, count));

                num = tree[i];
                count = 1;
            } else {
                ++count;
            }
        }
        pairs.add(new Pair(num, count));

        Pair prev = pairs.get(0);
        int max = prev.count;
        if (pairs.size() == 1) return max;

        Pair curr = pairs.get(1);
        int len = max + curr.count;
        max = len;

        for (int i = 2; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            if (pair.val == prev.val) {
                len += pair.count;
                if (len > max) max = len;
            } else {
                len = curr.count + pair.count;
                if (len > max) max = len;
            }

            prev = curr;
            curr = pair;
        }

        return max;
    }

    public static void main(String[] args) {
        Fruit_Into_Baskets solution = new Fruit_Into_Baskets();

        System.out.println(solution.totalFruit(ArrayUtility.toIntArray(1, 0, 3, 4, 3)));
        System.out.println(solution.totalFruit(ArrayUtility.toIntArray(1, 2, 1)));
        System.out.println(solution.totalFruit(ArrayUtility.toIntArray(0, 1, 2, 2)));
        System.out.println(solution.totalFruit(ArrayUtility.toIntArray(1, 2, 3, 2, 2)));
        System.out.println(solution.totalFruit(ArrayUtility.toIntArray(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)));
    }
}
