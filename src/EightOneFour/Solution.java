package EightOneFour;

import entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.logging.Handler;

class Solution {
    public TreeNode pruneTree(TreeNode root) {

        if(root==null)return root;
        TreeNode returnTreeNode = new TreeNode();
        returnTreeNode.left = root;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(returnTreeNode);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();

            if(helper(treeNode.left)){
                treeNode.left = null;
            }else {
                queue.add(treeNode.left);
            }

            if(helper(treeNode.right)){
                treeNode.right = null;
            }else {
                queue.add(treeNode.right);
            }
        }

        return returnTreeNode.left;
    }

    private boolean helper(TreeNode treeNode){
        if(treeNode==null)return true;

        boolean returnValue = false;
        if(helper(treeNode.left) && helper(treeNode.right) && treeNode.val==0){
            returnValue =true;
        }
        return returnValue;
    }
}