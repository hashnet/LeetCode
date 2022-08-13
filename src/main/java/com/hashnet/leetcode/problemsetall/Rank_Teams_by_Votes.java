package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.ArrayUtility;

import java.util.*;
import java.util.stream.Collectors;

public class Rank_Teams_by_Votes {
    private static class Candidate implements Comparable<Candidate> {
        char c;
        int len;
        int[] casts;

        public Candidate(char c, int len) {
            this.c = c;
            this.len = len;
            casts = new int[len];
        }

        @Override
        public int compareTo(Candidate o) {
            for (int i = 0; i < len; i++) {
                if (casts[i] < o.casts[i]) {
                    return +1;
                }
                if (casts[i] > o.casts[i]) {
                    return -1;
                }
            }

            return Character.compare(c, o.c);
        }

        public void addVote(int pos) {
            ++casts[pos];
        }
    }

    public String rankTeams(String[] votes) {
        int castCount = votes[0].length();
        Map<Character, Candidate> candidateMap = new HashMap<>();

        Arrays.stream(votes).forEach(vote -> {
            for(int i=0; i<vote.length(); i++) {
                char c = vote.charAt(i);

                if(!candidateMap.containsKey(c)) {
                    candidateMap.put(c, new Candidate(c, castCount));
                }

                Candidate candidate = candidateMap.get(c);
                candidate.addVote(i);
            }
        });

        return candidateMap.values()
                .stream()
                .sorted()
                .map(vote -> String.valueOf(vote.c))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Rank_Teams_by_Votes solution = new Rank_Teams_by_Votes();

        System.out.println(solution.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
        System.out.println(solution.rankTeams(new String[]{"WXYZ", "XYZW"}));
        System.out.println(solution.rankTeams(new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"}));
    }
}
