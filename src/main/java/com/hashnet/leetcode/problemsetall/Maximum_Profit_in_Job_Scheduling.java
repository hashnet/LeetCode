package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {
    private TreeSet<Integer> tags;
    private Map<Integer, Integer> result;

    private static class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return String.format("[%d - %d] -> %d", startTime, endTime, profit);
        }
    }

    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, Comparator.comparing(j -> j.endTime));

        for (int i = 1; i < len; i++) {
            Job thisJob = jobs.get(i);
            int maxProfitUptoThis = thisJob.profit;


            for (int j = i - 1; j >= 0; j--) {
                Job prevJob = jobs.get(j);
                if (prevJob.endTime <= thisJob.startTime) {
                    maxProfitUptoThis = Math.max(maxProfitUptoThis, prevJob.profit + thisJob.profit);
                    break;
                } else {
                    maxProfitUptoThis = Math.max(maxProfitUptoThis, prevJob.profit);
                }
            }

            thisJob.profit = maxProfitUptoThis;
        }

        return jobs.get(len - 1).profit;
    }


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Collections.sort(jobs, Comparator.comparing(j -> j.endTime));

        tags = new TreeSet<>();
        result = new HashMap<>();

        int maxProfit = 0;
        for (Job job : jobs) {
            int currentProfit = getProfitUpto(job.endTime);
            currentProfit = Math.max(currentProfit, getProfitUpto(job.startTime) + job.profit);
            maxProfit = Math.max(maxProfit, currentProfit);

            tags.add(job.endTime);
            result.put(job.endTime, maxProfit);
        }

        return maxProfit;
    }

    private int getProfitUpto(int upto) {
        Integer tag = tags.floor(upto);
        return tag == null ? 0 : result.get(tag);
    }

    public static void main(String[] args) {
        Maximum_Profit_in_Job_Scheduling solution = new Maximum_Profit_in_Job_Scheduling();

        if (solution.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}) != 120)
            throw new AssertionError();
        if (solution.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}) != 150)
            throw new AssertionError();
        if (solution.jobScheduling(new int[]{24, 24, 7, 2, 1, 13, 6, 14, 18, 24}, new int[]{27, 27, 20, 7, 14, 22, 20, 24, 19, 27}, new int[]{6, 1, 4, 2, 3, 6, 5, 6, 9, 8}) != 20)
            throw new AssertionError();
    }

}
