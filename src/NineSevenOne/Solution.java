package NineSevenOne;

import entity.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        List<Integer> list = new LinkedList<>();
        if(root==null){
            list.add(-1);
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        int i = 0;
        while(!stack.isEmpty()){
            int size = stack.size();
            while (size>0){
                size--;
                TreeNode treeNode = stack.pop();
                if(voyage[i]!=treeNode.val){
                    list.clear();
                    list.add(-1);
                    return list;
                }
                if(treeNode.left!=null && treeNode.left.val != voyage[i+1]){
                    list.add(treeNode.val);
                    stack.push(treeNode.left);
                    if(treeNode.right!=null)stack.push(treeNode.right);
                }else {
                    if(treeNode.right!=null)stack.push(treeNode.right);
                    if(treeNode.left!=null)stack.push(treeNode.left);
                }
                i++;
            }

        }

return list;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 1;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 3;
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode.left = treeNode1;
//        treeNode1.left = treeNode2;
        treeNode.right = treeNode1;
        treeNode1.right =treeNode2;
        Solution solution = new Solution();
        System.out.println(solution.flipMatchVoyage(treeNode,new int[]{1,3,2}));
    }

}
