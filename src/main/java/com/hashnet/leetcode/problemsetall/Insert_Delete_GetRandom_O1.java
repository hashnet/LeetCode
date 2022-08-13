package com.hashnet.leetcode.problemsetall;

import java.util.*;

class Insert_Delete_GetRandom_O1 {

    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public Insert_Delete_GetRandom_O1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            int index = list.size();
            list.add(val);
            map.put(val, index);

            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);

            map.put(list.get(list.size() - 1), index);
            Collections.swap(list, index, list.size() - 1);
            list.remove(list.size() - 1);
            map.remove(val);

            return true;
        } else {
            return false;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int size = list.size();
        if (size == 0) return 0;

        int next = rand.nextInt(size);

        return list.get(next);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */