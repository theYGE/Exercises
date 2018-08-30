package com.theYGE;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] some = {1, 2, 3, 4, 5};
        System.out.print(permute(some));
    }

    public static List<List<Integer>> permute(int[] nums) {

        List<Integer> tempList = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length == 1) {
            tempList.add(nums[0]);
            result.add(tempList);
            return result;
        }


        for (int i: nums)
            tempList.add(i);

        for (int i = 0; i< nums.length; i++) {
            int temp = tempList.remove(i);
            int[] newArray = new int[tempList.size()];
            for (int j=0; j<tempList.size(); j++)
                newArray[j] = tempList.get(j);
            List<List<Integer>> intermediate = permute(newArray);

            tempList.add(i, temp);

            for (List<Integer> returnedList: intermediate) {
                returnedList.add(0, temp);
                result.add(returnedList);
            }

        }
        return result;

    }
}
