package com.theYGE;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    class Solution {

        int[] original;

        public Solution(int[] nums) {
            this.original = nums.clone();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return original.clone();
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] newArray = original.clone();

            int rightIndex = newArray.length-1;
            for (int i = 0; i < newArray.length -1; i++) {
                Random rand = new Random();
                int range = rightIndex - i + 1;
                int generatedIndex = rand.nextInt(range) + i;

                int temp = newArray[i];
                newArray[i] = newArray[generatedIndex];
                newArray[generatedIndex] = temp;
            }
            return newArray;
        }
    }
}
