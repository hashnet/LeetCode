package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    
    private Map<Integer, Integer> keyToValueMap;
    private Map<Integer, Integer> keyToFrequencyMap;
    private int capacity;
    private Map<Integer, LinkedHashSet<Integer>> frequencyToKeysMap;
    private int minFrequency;

    public LFUCache(int capacity) {
        this.keyToValueMap = new HashMap<>();
        this.keyToFrequencyMap = new HashMap<>();
        this.capacity = capacity;
        this.frequencyToKeysMap = new HashMap<>();
        this.minFrequency = 0;
    }
    
    public int get(int key) {
        if(!keyToValueMap.containsKey(key)) {
            return -1;
        }
        
        // bump frquency
        increaseFrequency(key);
        
        // return
        return keyToValueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0) {
            return;
        }
        
        if(keyToValueMap.containsKey(key)) {
            // update key-value
            keyToValueMap.put(key, value);
            
            // bump frequency
            increaseFrequency(key);
            
            return;
        }
        
        if(keyToValueMap.size() >= capacity) {
            removeMinFrequentKey();
        }
        
        // add key-value
        keyToValueMap.put(key, value);
        // add key-frequency
        keyToFrequencyMap.put(key, 1);
        // add frequency-keys
        frequencyToKeysMap.putIfAbsent(1, new LinkedHashSet<>());
        frequencyToKeysMap.get(1).add(key);
        // update min frequency
        this.minFrequency = 1;
    }
    
    private void increaseFrequency(int key) {
        // get old frequency
        int frequency = keyToFrequencyMap.get(key);
        int newFrequency = frequency + 1;
        // update key-frequency
        keyToFrequencyMap.put(key, newFrequency);
        // remove from old frequency map
        frequencyToKeysMap.get(frequency).remove(key);
        // add to new frequency map
        frequencyToKeysMap.putIfAbsent(newFrequency, new LinkedHashSet<>());
        frequencyToKeysMap.get(newFrequency).add(key);
        // update min frequency
        if(frequencyToKeysMap.get(frequency).isEmpty()) {
            frequencyToKeysMap.remove(frequency);
            
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }
        
    }
    
    private void removeMinFrequentKey() {
        // get key
        LinkedHashSet<Integer> keySet = frequencyToKeysMap.get(minFrequency);
        int key = keySet.iterator().next();
        // remove
        // k-v
        keyToValueMap.remove(key);
        // k-f
        keyToFrequencyMap.remove(key);
        // f-k
        keySet.remove(key);
        if(keySet.size() == 0) {
            frequencyToKeysMap.remove(minFrequency);
        }
    }

    public static void main(String[] args) {
       // cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=3
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=4
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=4
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=4
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=3, cnt(1)=4
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=4, cnt(1)=4
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=4
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
    }
}