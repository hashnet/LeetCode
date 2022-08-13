package com.hashnet.leetcode.problemsetall;

import java.util.*;

public class Time_Based_Key_Value_Store {
    public static class TimeMap {
        public static class ValueMap {
            List<Integer> timestamps;
            Map<Integer, String> values;

            public ValueMap() {
                timestamps = new ArrayList<>();
                values = new HashMap<>();
            }

            public void addValue(int timestamp, String value) {
                timestamps.add(timestamp);
                values.put(timestamp, value);
            }

            public String getValue(int timestamp) {
                int index = floor(timestamp);

                if (index < 0) return "";

                else return values.get(timestamps.get(index));
            }

            private int floor(int timestamp) {
                int index = Collections.binarySearch(timestamps, timestamp);

                if (index >= 0 || index == -1) return index;

                return -index - 2;
            }
        }

        Map<String, ValueMap> keyValeMap;

        public TimeMap() {
            keyValeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            ValueMap valueMap = keyValeMap.getOrDefault(key, new ValueMap());
            valueMap.addValue(timestamp, value);
            keyValeMap.put(key, valueMap);
        }

        public String get(String key, int timestamp) {
            return keyValeMap.containsKey(key)
                    ? keyValeMap.get(key).getValue(timestamp)
                    : "";
        }
    }

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
