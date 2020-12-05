package OneZeroTwo;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> totalList = new ArrayList<>();
        if(root==null){
            return totalList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();

       queue.add(root);
       Queue<TreeNode> current = queue;
       Queue<TreeNode> next = queue1;
        while(!current.isEmpty()){
            List<Integer> list = new LinkedList<>();
            while (!current.isEmpty()){
                TreeNode treeNode = current.poll();
                if(treeNode==null){
                    continue;
                }
                next.add(treeNode.left);
                next.add(treeNode.right);
                list.add(treeNode.val);
            }
            if(list.size()!=0)
            totalList.add(list);
            Queue<TreeNode> temp = current;
            current = next;
            next = temp;
        }

        return totalList;
    }

    public void helper(TreeNode root,Queue<TreeNode> queue){

        if(root==null){
            System.out.print(" null ");
            queue.add(null);
            return;
        }
        System.out.print(root.val);
        queue.add(root);

        helper(root.left,queue);
        helper(root.right,queue);


        return ;
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}