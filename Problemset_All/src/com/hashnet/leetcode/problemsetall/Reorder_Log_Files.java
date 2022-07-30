package com.hashnet.leetcode.problemsetall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Reorder_Log_Files {
    private class Log implements Comparable<Log>{
        String log;
        String id;
        String body;
        Boolean isNumeric;

        public Log(String log) {
            this.log = log;

            String[] split = log.split(" ", 2);
            this.id = split[0];
            this.body = split[1];
            this.isNumeric = Character.isDigit(this.body.charAt(0));
        }

        @Override
        public int compareTo(Log other) {
            if(!this.isNumeric && !other.isNumeric) {
                int comp = this.body.compareTo(other.body);
                if(comp != 0) return comp;
                else {
                    return this.id.compareTo(other.id);
                }
            }

            if(this.isNumeric) {
                if(other.isNumeric) {
                    return 0;
                } else {
                    return +1;
                }
            } else {
                return -1;
            }
        }
    }
    public String[] reorderLogFiles(String[] logs) {
        List<Log> logLists= new ArrayList<>();
        Arrays.stream(logs).forEach((log) -> {
            logLists.add(new Log(log));
        });

        Collections.sort(logLists);

        return logLists.stream().map(log -> log.log).toArray(String[]::new);
    }

    public static void main(String[] args) {
        Reorder_Log_Files solution = new Reorder_Log_Files();

        System.out.println(Arrays.stream(solution.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})).collect(Collectors.joining(", ")));
    }
}
