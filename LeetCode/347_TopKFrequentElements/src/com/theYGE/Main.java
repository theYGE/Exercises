package com.theYGE;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] test = {5,3,1,1,1,3,73,1} ;
        System.out.print(topKFrequent(test, 2));
    }
        public static List<Integer> topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> frequencies = new HashMap<Integer,Integer>();
            int maxFrequency = 0;

            for (int i = 0; i<nums.length; i++) {
                frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
                if (frequencies.get(nums[i]) > maxFrequency) {
                    maxFrequency = frequencies.get(nums[i]);
                }
            }

            List<Integer>[] buckets = new LinkedList[maxFrequency + 1];

            for (int i = 0; i < maxFrequency + 1; i ++) {
                buckets[i] = new LinkedList<>();
            }

            for (Integer key: frequencies.keySet()) {
                buckets[frequencies.get(key)].add(key);
            }

            List<Integer> result = new ArrayList<Integer>();
            int numberOfAdded = 0;
            for (int i = maxFrequency; (i > 0); i--) {

                for (Integer number: buckets[i]) {
                    if (numberOfAdded == k)
                        return result;
                    else {
                        numberOfAdded++;
                        result.add(number);
                    }
                }
            }

            return result;
    }

}
