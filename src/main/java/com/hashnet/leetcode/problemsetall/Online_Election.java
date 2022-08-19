package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.PrintUtility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Online_Election {
    public static class TopVotedCandidate {
        public class Vote implements Comparable<Vote>{
            private final int person;
            private final int time;

            public Vote(int person, int time) {
                this.person = person;
                this.time = time;
            }

            @Override
            public String toString() {
                return "Vote{" +
                        "person=" + person +
                        ", time=" + time +
                        '}';
            }

            @Override
            public int compareTo(Vote o) {
                return Integer.compare(time, o.time);
            }
        }

        Map<Integer, Integer> personalVotes;
        List<Vote> timeVotes;

        int leaderName = Integer.MIN_VALUE;
        int leaderVote = 0;
        public TopVotedCandidate(int[] persons, int[] times) {
            personalVotes = new HashMap<>();
            timeVotes = new ArrayList<>();

            for(int i=0; i<persons.length; i++) {
                int person = persons[i];
                int time = times[i];

                int vote = personalVotes.compute(person, (k, v) -> v == null ? 1 : v+1);

                if(vote >= leaderVote) {
                    leaderName = person;
                    leaderVote = vote;
                }

                timeVotes.add(new Vote(leaderName, leaderVote));
            }

            System.out.println(PrintUtility.prettyPrint(personalVotes));
            System.out.println(PrintUtility.prettyPrint(timeVotes));
        }

        public int q(int t) {
            return 0;
        }
    }

    public static void main(String[] args) {
        TopVotedCandidate solution = new TopVotedCandidate(new int[] {0, 1, 1, 0, 0, 1, 0}, new int[] {0, 5, 10, 15, 20, 25, 30});

        System.out.println(solution.q(3));
        System.out.println(solution.q(12));
        System.out.println(solution.q(25));
        System.out.println(solution.q(15));
        System.out.println(solution.q(24));
        System.out.println(solution.q(8));

    }
}
