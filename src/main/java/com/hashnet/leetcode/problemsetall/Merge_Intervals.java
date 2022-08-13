package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public String toString() {
            return String.format("[%2d, %2d]", start, end);
        }
    }

    public static void main(String[] args) {
        Merge_Intervals s = new Merge_Intervals();
        List<Interval> intervals = new ArrayList<>();
//		[[1,3],[2,6],[8,10],[15,18]]
        intervals.add(s.new Interval(1, 3));
        intervals.add(s.new Interval(2, 6));
        intervals.add(s.new Interval(8, 10));
        intervals.add(s.new Interval(15, 18));
        System.out.println(s.merge(intervals));
    }

    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort(new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) return result;

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);

            if (isOverlapping(prev, next)) {
                prev = new Interval(prev.start, Math.max(prev.end, next.end));
            } else {
                result.add(prev);
                prev = next;
            }
        }

        result.add(prev);

        return result;
    }

    private boolean isOverlapping(Interval prev, Interval next) {
        if (prev.end >= next.start) return true;
        else return false;
    }
}
