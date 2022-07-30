package com.hashnet.leetcode.problemsetall;

public class GetStringReplacingString {
    public String solution(String S, String T) {
        int lenS = S.length();
        int lenT = T.length();

        if(Math.abs(lenS - lenT) > 1) {
            return "IMPOSSIBLE";
        }

        if(lenS == lenT) {
            for(int i=0; i<lenS; i++) {
                if(S.charAt(i) != T.charAt(i)) {
                    if(isMatchWithMove(S, i+1, T, i, S.charAt(i))) {
                        return "MOVE " + S.charAt(i);
                    } else {
                        return "IMPOSSIBLE";
                    }
                }
            }

            return "NOTHING";
        } else {
            if(lenS > lenT) {
                Object[] result = isMatchByDel(S, T);
                if((boolean)result[0]) {
                    return "REMOVE " + (char)result[1];
                } else {
                    return "IMPOSSIBLE";
                }
            } else {
                Object[] result = isMatchByDel(T, S);
                if((boolean)result[0]) {
                    return "INSERT " + (char)result[1];
                } else {
                    return "IMPOSSIBLE";
                }
            }
        }
    }

    private Object[] isMatchByDel(String S, String T) {
        int si = 0, ti = 0;
        char del = '0';
        int unMatch = 0;

        while(ti < T.length()) {
            if(S.charAt(si) != T.charAt(ti)) {
                if(unMatch > 0) return new Object[] {false, '0'};
                else {
                    del = S.charAt(si);
                    ++unMatch;
                    ++si;
                }
            } else {
                ++si;
                ++ti;
            }
        }

        if(unMatch == 0) {
            return new Object[]{true, S.charAt(S.length()-1)};
        } else {
            return new Object[]{true, del};
        }
    }

    private boolean isMatchWithMove(String S, int si, String T, int ti, char c) {
        if(si >= S.length()) {
            return false;
        }

        boolean moved = false;
        while(ti < T.length()) {
            if(si >= S.length()) {
                si = S.length()-1;
            }

            if(S.charAt(si) != T.charAt(ti)) {
                if(moved) {
                    return false;
                } else if(T.charAt(ti) == c){
                    moved = true;
                    ++ti;
                } else {
                    return false;
                }
            }else {
                ++si;
                ++ti;
            }
        }

        return moved;
    }

    public static void main(String[] args) {
        GetStringReplacingString solution = new GetStringReplacingString();
        System.out.println(solution.solution("nice", "niece"));
        System.out.println(solution.solution("b", ""));
//        System.out.println(solution.solution("crow", "cow"));
//        System.out.println(solution.solution("beans", "banes"));
//        System.out.println(solution.solution("beans", "beand"));
//        System.out.println(solution.solution("beans", "bensa"));
//        System.out.println(solution.solution("a", "b"));
//        System.out.println(solution.solution("o", "odd"));

    }
}
