package NonRecrusiveInorder;

import entity.TreeNode;

import javax.swing.table.TableRowSorter;
import java.util.*;

public class Solution {

    public void inOrder(TreeNode treeNode) {

        Stack<TreeNode> stack = new Stack<>();

        //Map<TreeNode,Boolean> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        if(treeNode==null)return;
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode treeNode1 = stack.peek();

            while(treeNode1.left!=null){
                stack.push(treeNode1.left);
                treeNode1 = treeNode1.left;
            }
            TreeNode treeNode2 = stack.pop();
            //System.out.println(treeNode2.val);
            list.add(treeNode2.val);

            while(treeNode2.right==null){
                if(stack.isEmpty())return;
                TreeNode treeNode3 = stack.pop();
                //System.out.println(treeNode3.val);
                list.add(treeNode3.val);
                treeNode2 = treeNode3;
            }
            stack.push(treeNode2.right);
        }
    }


    public static void main(String[] args) {
        TreeNode treeNode5 = new TreeNode();
        treeNode5.val = 5;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 4;
        TreeNode treeNode8 = new TreeNode();
        treeNode8.val = 8;
        TreeNode treeNode11 = new TreeNode();
        treeNode11.val = 11;
        TreeNode treeNode13 = new TreeNode();
        treeNode13.val = 13;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.val = 6;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode8;
        treeNode4.left = treeNode11;
        treeNode8.left = treeNode13;
        treeNode8.right = treeNode6;

        Solution solution = new Solution();
        solution.inOrder(treeNode5);
    }
}
