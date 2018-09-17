package com.theYGE;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int x = kthSmallest(root, 4);
    }


      //Definition for a binary tree node.
      public static class TreeNode {
         int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

        static List<Integer> numbers = new ArrayList<>();
        public static int kthSmallest(TreeNode root, int k) {
            formList(root);

            return numbers.get(k-1);
        }

        public static void formList(TreeNode root) {
            if (root == null)
                return;

            formList(root.left);

            numbers.add(numbers.size(), root.val);

            formList(root.right);
    }
}
