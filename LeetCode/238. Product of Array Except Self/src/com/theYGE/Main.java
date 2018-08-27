package com.theYGE;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //System.out.print();
        int[] temp = {5 ,2, 3, 4};
        int[] result = productExceptSelf(temp);
        System.out.print(Arrays.toString(result));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i< nums.length; i++) {
            output[i] = 1;
        }
        int temp = 1;

        for (int i = 0; i<nums.length; i++) {
            output[i] *= temp;
            temp *= nums[i];
        }

        temp = 1;
        for (int i = nums.length-1; i>=0; i--) {
            output[i] *= temp;
            temp *= nums[i];
        }
        return output;
    }
}
