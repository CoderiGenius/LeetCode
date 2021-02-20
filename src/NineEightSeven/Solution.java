package NineEightSeven;

import entity.TreeNode;

import java.util.*;

public class Solution {

    NewTreeNode newTreeNode;
//    int maxX = 0;
//    int minX = 0;
    TreeMap<Integer,List<NewTreeNode>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list = new LinkedList<>();
        List<Integer> list1 = new LinkedList<>();
        if(root==null)return list;

        newTreeNode = new NewTreeNode();
        newTreeNode.treeNode = new TreeNode();
        newTreeNode.x = 1;
        newTreeNode.y = 1;
        newTreeNode.treeNode.left = root;

        helper(newTreeNode);

        for (Integer integer :map.keySet()
             ) {
            List<Integer> list3 = new LinkedList<>();
            List<NewTreeNode> list2 = map.get(integer);
            for (NewTreeNode n :
                    list2) {
                list3.add(n.treeNode.val);
            }
            list.add(list3);
        }
        return list;
    }



    private void helper(NewTreeNode newTreeNode){
        NewTreeNode left = null;
        NewTreeNode right = null;

        if(newTreeNode.treeNode.right!=null) {
            right = new NewTreeNode();
            right.treeNode = newTreeNode.treeNode.right;
            right.x = newTreeNode.x + 1;
            right.y = newTreeNode.y - 1;
            newTreeNode.right = right;
            //maxX = Math.max(maxX,right.x);

            List<NewTreeNode> list = map.get(right.x);
            if(list==null){
                list = new LinkedList<>();
                list.add(right);
                map.put(right.x,list);
            }else {
                list.add(right);
                Collections.sort(list);

            }
        }

        if(newTreeNode.treeNode.left!=null) {
            left = new NewTreeNode();
            left.treeNode = newTreeNode.treeNode.left;
            left.x = newTreeNode.x - 1;
            left.y = newTreeNode.y - 1;
            newTreeNode.left = left;
            //map.put(left.x,left);

            List<NewTreeNode> list = map.get(left.x);
            if(list==null){
                list = new LinkedList<>();
                list.add(left);
                map.put(left.x,list);
            }else {

                list.add(left);
                Collections.sort(list);

            }


            //minX = Math.min(minX,left.x);


        }


       if(right!=null) helper(right);
        if(left!=null) helper(left);
    }

    class NewTreeNode implements Comparable<NewTreeNode>{
        TreeNode treeNode;
        int x;
        int y;
        NewTreeNode left;
        NewTreeNode right;

        @Override
        public String toString() {
            return "NewTreeNode{" +
                    "treeNode=" + treeNode +
                    ", x=" + x +
                    ", y=" + y +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int compareTo(NewTreeNode that) {
            if (this.x != that.x)
                return Integer.compare(this.x, that.x);
            else if (this.y != that.y)
                return Integer.compare(this.y, that.y);
            else
                return Integer.compare(this.treeNode.val, that.treeNode.val);


        }
    }
}
