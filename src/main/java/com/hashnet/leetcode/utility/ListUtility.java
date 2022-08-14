package com.hashnet.leetcode.utility;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtility {
    public static String prettyPrint(Object objects) {
        if (objects instanceof Collection) {
            return (String) ((Collection) objects).stream()
                    .map(ListUtility::prettyPrint)
                    .collect(Collectors.joining(",", "[", "]"));
        } else {
            return String.valueOf(objects);
        }
    }

    public static void main(String[] args) {
        System.out.println(prettyPrint("ABCD"));
        System.out.println(prettyPrint(1));
        System.out.println(prettyPrint(List.of("A", "BC", "D")));
        System.out.println(prettyPrint(List.of(1, 23, 4)));
        System.out.println(prettyPrint(List.of("A", 23, "D")));
        System.out.println(prettyPrint(List.of("A", List.of(2, 3), "D")));
        System.out.println(prettyPrint(List.of("A", List.of(2, List.of('C', 'D'), 0.4), "EF")));
    }
}
