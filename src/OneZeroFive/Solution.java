package OneZeroFive;

import entity.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/3/23 12:58 下午
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        if(preorder.length==2){
           if(preorder[0]==inorder[0]){
               TreeNode root = new TreeNode(preorder[0]);
               TreeNode right = new TreeNode(preorder[1]);
               root.right = right;
               return root;
           }else {
               TreeNode root = new TreeNode(preorder[0]);
               TreeNode left = new TreeNode(preorder[1]);
               root.left = left;
               return root;
           }
        }
        if(preorder.length==1){
            TreeNode root = new TreeNode(preorder[0]);
            return root;
        }
        if(preorder.length==0)return null;



        int findRootPositionInInOrderMap = map.get(preorder[0]);
        int[] leftTreeInOrder = Arrays.copyOfRange(inorder,0,findRootPositionInInOrderMap);
        int[] rightTreeInOrder = Arrays.copyOfRange(inorder,findRootPositionInInOrderMap+1,inorder.length);

        int[] leftTreePreOrder = Arrays.copyOfRange(preorder,1,leftTreeInOrder.length+1);
        int[] rightTreePreOrder = Arrays.copyOfRange(preorder,1+leftTreeInOrder.length,preorder.length);

        TreeNode root = new TreeNode(preorder[0]);
        root.left = buildTree(leftTreePreOrder,leftTreeInOrder);
        root.right = buildTree(rightTreePreOrder,rightTreeInOrder);
        return root;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7}));
        System.out.println(solution.buildTree(new int[]{1,2,3}, new int[]{3,2,1}));

    }
    private boolean checkIfTheTwoNodesAreOnBothSides(Map<Integer,Integer> map,Integer first,Integer second,int position){
        Integer firstPosition = map.get(first);
        Integer secondPosition = map.get(second);
        if(firstPosition<position && secondPosition>position){
            return true;
        }
        if(firstPosition>position && secondPosition<position){
            return true;
        }
        return false;
    }
}
