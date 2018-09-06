package com.theYGE;

import com.sun.istack.internal.Nullable;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.print(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<HashSet<Integer>>> state = new ArrayList<ArrayList<HashSet<Integer>>>(Collections.nCopies(nums.length, null));

        ArrayList<HashSet<Integer>> fixedState = new ArrayList<HashSet<Integer>>();
        for (int number: nums) {
            HashSet<Integer> someSet = new HashSet<>();
            someSet.add(number);
            fixedState.add(someSet);
        }

        state.set(0, fixedState);
        for (int i = 1; i < nums.length; i++) {
            ArrayList<HashSet<Integer>> previous = state.get(i-1);
            ArrayList<HashSet<Integer>> toAdd = new ArrayList<HashSet<Integer>>();
            for (HashSet<Integer> set : previous) {
                for (int number: nums) {
                    if (!set.contains(number)) {
                        HashSet<Integer> setForAdding = (HashSet<Integer>)set.clone();
                        setForAdding.add(number);
                        if (!toAdd.contains(setForAdding))
                            toAdd.add(setForAdding);
                    }
                }
            }
            state.set(i, toAdd);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (List<HashSet<Integer>> outer : state)
            for (HashSet<Integer> inner: outer) {
                List<Integer> someList = new ArrayList<>();
                someList.addAll(inner);
                answer.add(someList);
            }
        answer.add(new ArrayList<>());
        return answer;
    }

}

class Solution {

}