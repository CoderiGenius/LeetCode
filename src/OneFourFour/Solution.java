package OneFourFour;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if(treeNode.right!=null)
            stack.push(treeNode.right);
            if(treeNode.left!=null)
            stack.push(treeNode.left);
        }
        return list;
    }
}
