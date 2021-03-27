package OneOneFour;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author CoderiGenius
 * @version 2021/3/24 2:06 下午
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root==null)return;

//        Queue<TreeNode> queue = new LinkedList<>();
//
//        helper(root,queue);
//
//        TreeNode lastTreeNode = queue.poll();
//
//        while (!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            lastTreeNode.right = temp;
//            lastTreeNode.left = null;
//            lastTreeNode = temp;
//        }


        while(root!=null){
            if(root.left!=null){
                TreeNode tempLeft = root.left;
                TreeNode temp = root.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                temp.right = root.right;
                root.right = tempLeft;
            }
            root = root.right;
        }

    }
    private void helper(TreeNode treeNode,Queue<TreeNode> queue){
        if(treeNode==null)return;

        queue.add(treeNode);
        helper(treeNode.left,queue);
        helper(treeNode.right,queue);
    }
}
