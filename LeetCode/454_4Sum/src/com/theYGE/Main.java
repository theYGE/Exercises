package com.theYGE;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        fourSumCount()
    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int numberOfTuples = 0;

        Map<Integer, Integer> hashAB = new HashMap<Integer, Integer>();

        for (int i =0; i < A.length; i++)
            for (int j = 0; j < B.length; j++)
            {
                int sum = A[i] + B[j];
                if (hashAB.containsKey(sum))
                    hashAB.put(sum, hashAB.get(sum) + 1);
                else
                    hashAB.put(sum, 1);
            }

        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++)
            {
                int sum = C[i] + D[j];
                sum = sum * (-1);
                if (hashAB.containsKey(sum))
                    numberOfTuples += hashAB.get(sum);
            }
        return numberOfTuples;
    }
}
