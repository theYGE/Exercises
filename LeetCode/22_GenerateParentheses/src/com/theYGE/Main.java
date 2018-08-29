package com.theYGE;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.print(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();

        if (n == 0) {
            result.add("");
            return result;
        }

        for (int i = 0; i < n; i++) {
            for (String left: generateParenthesis(i)) {
                for (String right: generateParenthesis(n-1-i)) {
                    result.add("(" + left + ")" + right);
                }
            }
        }

        return result;
    }
}
