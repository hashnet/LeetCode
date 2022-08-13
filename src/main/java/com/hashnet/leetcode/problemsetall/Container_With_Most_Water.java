package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int maxVol = 0;

        int i = 0;
        int j = height.length - 1;
        int width = j - i;
        int minHeight;
        while (j > i) {
            if (height[i] <= height[j]) {
                minHeight = height[i];
                ++i;
            } else {
                minHeight = height[j];
                --j;
            }
            int currVol = minHeight * width;
            if (currVol > maxVol) maxVol = currVol;

            --width;
        }

        return maxVol;
    }

    public static void main(String[] args) {
        Container_With_Most_Water solution = new Container_With_Most_Water();

        System.out.println(solution.maxArea(ArrayUtility.toIntArray(1, 1)));
        System.out.println(solution.maxArea(ArrayUtility.toIntArray(1, 8, 6, 2, 5, 4, 8, 3, 7)));
    }
}
