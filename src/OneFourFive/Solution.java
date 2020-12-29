package OneFourFive;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new LinkedList<>();
        if(root==null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> resultStack = new Stack<>();

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            resultStack.push(treeNode);

            if(treeNode.left!=null)
                stack.push(treeNode.left);
            if(treeNode.right!=null)
                stack.push(treeNode.right);

        }

        while (!resultStack.isEmpty()){
            list.add(resultStack.pop().val);
        }
        return list;
    }
}
