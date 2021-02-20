package SixSixTwo;

import entity.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    int n = 0;
    public int widthOfBinaryTree(TreeNode root) {

        if(root==null)return 0;
        if(root.right==null && root.left==null)return 1;

        Deque<TreeNode> stack = new LinkedList<>();
       // Deque<TreeNode> stack1 = new LinkedList<>();
        stack.add(root);
        root.val = 1;


        while (!stack.isEmpty()){
      int size = stack.size();
            while (size>0) {
                TreeNode treeNode = stack.poll();
                if(treeNode.left!=null) {
                    treeNode.left.val = treeNode.val * 2 - 1;
                    stack.add(treeNode.left);
                  //  if(left==null)left = treeNode.left.val;
                    //if(right==null && stack.isEmpty() && treeNode.right==null)right = treeNode.left.val;
                }

                if(treeNode.right!=null){
                    treeNode.right.val = treeNode.val *2;
                    stack.add(treeNode.right);
//                    if(left==null)left = treeNode.right.val;
//                    if(right==null && stack.isEmpty())right = treeNode.right.val;
                }
            size--;
            }
            if(!stack.isEmpty())n = Math.max(stack.peekLast().val-stack.peekFirst().val+1,n);


        }
        return n;
    }




    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 2;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val =1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 4;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val =3;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 5;
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode2.left = treeNode4;
        Solution solution = new Solution();
        System.out.println(solution.widthOfBinaryTree(treeNode));
    }
}
