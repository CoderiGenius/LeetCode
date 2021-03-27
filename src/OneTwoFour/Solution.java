package OneTwoFour;

import entity.TreeNode;

/**
 * @author CoderiGenius
 * @version 2021/3/24 4:10 下午
 */
public class Solution {
    static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if(root==null){
            return max;
        }
        preOrder(root);

        return max;

    }

    private void preOrder(TreeNode treeNode){
        if(treeNode==null)return;

        int left = helper(treeNode.left);
        int right = helper(treeNode.right);
        int leftAndRightBoth_OnlyRoot =Math.max(left+right+treeNode.val,treeNode.val);
        int leftOrRight = Math.max(left+treeNode.val,right+treeNode.val);
        max = Math.max(Math.max(leftOrRight,leftAndRightBoth_OnlyRoot),max);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }
    //找当前节点最大值 一条路
    private int helper(TreeNode root){
        if(root==null)return 0;
        int left = 0;
        int right = 0;
        if(root.right!=null){
            right = helper(root.right);
        }
        if(root.left!=null){
            left = helper(root.left);
        }
        return Math.max(root.val,Math.max(right,left)+root.val);

    }
}
