package FiveFourThree;

import entity.TreeNode;

public class Solution {

    int x = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)return 0;
        findTheLongestRoad(root);

        return x;
    }

    private int findTheLongestRoad(TreeNode treeNode){
        if(treeNode==null)return 0;

        int left = findTheLongestRoad(treeNode.left);
        int right = findTheLongestRoad(treeNode.right);

        x = Math.max(left+right,x);

        return Math.max(left,right)+1;
    }
}
