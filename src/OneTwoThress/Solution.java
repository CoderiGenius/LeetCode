package OneTwoThress;


import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> totalList = new ArrayList<>();
        if(root==null){
            return totalList;
        }
        // Queue<TreeNode> queue = new LinkedList<>();
        //Queue<TreeNode> queue1 = new LinkedList<>();


        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        int i = 0;
        current.add(root);
        while(!current.isEmpty()){
            List<Integer> list = new LinkedList<>();
            while (!current.isEmpty()){
                TreeNode treeNode = current.pop();
                if(treeNode==null){
                    continue;
                }
                if(i==0){
                    //right
                    next.add(treeNode.right);
                    next.add(treeNode.left);
                    list.add(treeNode.val);
                    i=1;
                }else{
                    //left
                    next.add(treeNode.left);
                    next.add(treeNode.right);
                    list.add(treeNode.val);
                    i=0;
                }

            }
            if(list.size()!=0)
                totalList.add(list);
            Stack<TreeNode> temp = current;
            current = next;
            next = temp;
        }

        return totalList;
    }

    class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
