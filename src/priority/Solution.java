package priority;

import entity.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        PriorityQueue<TreeNode> treeNodes = new PriorityQueue<>(new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                return -o1.val+o2.val;
            }
        });

        TreeNode treeNode = new TreeNode();
        treeNode.val=0;
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 2;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val =-19;
        treeNodes.add(treeNode);
        treeNodes.add(treeNode1);
        treeNodes.add(treeNode2);

        System.out.println(treeNodes.poll());
    }
}
