package LowestCommonAncester;

import entity.Node;

public class Solution {


    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        if(root==null)return null;
        return helper(root,v1,v2);
    }

    private static Node helper(Node root, int v1, int v2){
        if(root==null)return null;
        if(root.data==v1 || root.data==v2)return root;

        Node left = helper(root.left,v1,v2);
        Node right = helper(root.right,v1,v2);

        if(left==null && right==null){
            return null;
        }
        if(left!=null && right!=null){
            return root;
        }
        if(left==null){
            return right;
        }
        else{
            return left;
        }

    }


    public static void main(String[] args) {
        Node n7 = new Node();
        n7.data = 7;
        Node node4 = new Node();
        node4.data = 4;
        Node node2 = new Node();
        node2.data = 2;
        Node node1 = new Node();
        node1.data = 1;
        Node node3 = new Node();
        node3.data = 3;
        Node node6 =new Node();
        node6.data = 6;
        node4.left = node2;
        node4.right = n7;
        n7.left = node6;
        node2.left = node1;
        node2.right = node3;

        System.out.println(lca(node4,1,7).data);
    }
}
