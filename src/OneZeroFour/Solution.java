package OneZeroFour;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CoderiGenius
 * @version 2021/3/23 12:25 下午
 */
class Solution {
//    public int maxDepth(TreeNode root) {
//
//        if(root==null)return 0;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        int depth = 0;
//        queue.add(root);
//
//        while (!queue.isEmpty()){
//            TreeNode treeNode = queue.poll();
//            if(treeNode.left!=null)queue1.add(treeNode.left);
//            if(treeNode.right!=null)queue1.add(treeNode.right);
//            if(queue.isEmpty()){
//                depth++;
//                Queue<TreeNode> temp = queue;
//                queue = queue1;
//                queue1 = temp;
//            }
//        }
//        return depth;
//    }

    public int maxDepth(TreeNode root) {

        if(root==null)return 0;

        int left = 0;
        int right = 0;
        if(root.left!=null)left = maxDepth(root.left);
        if(root.right!=null)right = maxDepth(root.right);
        return Math.max(left,right)+1;

    }
//    private int helper(TreeNode root){
//        if(root==null)return 0;
//        int left = 0;
//        int right = 0;
//        if(root.left!=null)left = helper(root.left);
//        if(root.right!=null)right = helper(root.right);
//        return Math.max(left,right)+1;
//    }
}