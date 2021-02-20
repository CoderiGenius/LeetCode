package OneNineNine;

import entity.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) return integers;

        Queue<TreeNode> stack1 = new LinkedList<>();
        Queue<TreeNode> stack2 = new LinkedList<>();

        stack1.add(root);
        Queue<TreeNode> stack = stack1;
        Queue<TreeNode> anotherStack = stack2;
        while (!stack.isEmpty()) {
            TreeNode treeNode = null;

            treeNode = stack.poll();
            if (stack.isEmpty()) {
                integers.add(treeNode.val);

                if (treeNode.left != null) anotherStack.add(treeNode.left);
                if (treeNode.right != null) anotherStack.add(treeNode.right);
                Queue<TreeNode> temp = stack;
                stack = anotherStack;
                anotherStack = temp;

            }else {

                if (treeNode.left != null) anotherStack.add(treeNode.left);
                if (treeNode.right != null) anotherStack.add(treeNode.right);
            }

        }
        return integers;
    }
}
