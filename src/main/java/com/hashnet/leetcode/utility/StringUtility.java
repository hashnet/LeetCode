package com.hashnet.leetcode.utility;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtility {

    public static Stream<Character> stringToStreamOfCharacter(String str) {
        return str.chars()
            .mapToObj(i -> (char) i);
    }

    private static String printCharacterStream(Stream<Character> characterStream) {
        return characterStream.map(String::valueOf)
            .collect(Collectors.joining(",", "[", "]"));
    }

    public static void main(String[] args) {
        System.out.println(printCharacterStream(stringToStreamOfCharacter("STRING")));
    }
}
