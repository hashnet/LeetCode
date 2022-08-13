package com.hashnet.leetcode.problemsetall;

public class String_to_Integer_atoi2 {
    private enum State {
        Started,
        GetDigit
    }

    public int myAtoi(String str) {
        State state = State.Started;
        long result = 0;
        boolean isPositive = true;
        if (str == null || str.length() == 0) return 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (state != State.Started) return (int) result;
            } else if (c == '+' || c == '-') {
                if (state == State.Started) {
                    state = State.GetDigit;

                    if (str.charAt(i) == '-') {
                        isPositive = false;
                    }
                } else {
                    return (int) result;
                }
            } else if (c >= '0' && c <= '9') {
                state = State.GetDigit;

                if (isPositive) {
                    result = (result * 10) + (c - '0');
                    if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                } else {
                    result = (result * 10) - (c - '0');
                    if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
            } else {
                return (int) result;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        String_to_Integer_atoi2 solution = new String_to_Integer_atoi2();

        System.out.println(solution.myAtoi("-5-"));
        System.out.println(solution.myAtoi("  "));
        System.out.println(solution.myAtoi("  -123  "));
        System.out.println(solution.myAtoi("  +123  "));
        System.out.println(solution.myAtoi("  +12 3  "));
        System.out.println(solution.myAtoi("9999999999999999999999"));

    }
}
