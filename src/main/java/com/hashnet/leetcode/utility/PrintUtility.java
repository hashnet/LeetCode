package com.hashnet.leetcode.utility;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintUtility {

    public static String prettyPrint(Object objects) {
        if (objects instanceof Set) {
            return ((Set<Object>) objects).stream()
                .map(PrintUtility::prettyPrint)
                .collect(Collectors.joining(",", "(", ")"));
        } else if (objects instanceof Collection) {
            return (String) ((Collection) objects).stream()
                .map(PrintUtility::prettyPrint)
                .collect(Collectors.joining(",", "[", "]"));
        } else if (objects instanceof Map) {
            return ((Map<Object, Object>) objects).entrySet()
                .stream()
                .map(e -> prettyPrint(e.getKey()) + ":" + prettyPrint(e.getValue()))
                .collect(Collectors.joining(",", "{", "}"));
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
        System.out.println(prettyPrint(Stream.of("A", List.of(2, 3), "D").collect(Collectors.toMap(Object::hashCode, l -> l))));
        System.out.println(prettyPrint(Stream.of("A", Set.of(2, 3), "D").collect(Collectors.toMap(Object::hashCode, l -> l))));
    }
}
