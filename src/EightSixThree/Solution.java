package EightSixThree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    Map<TreeNode,TreeNode> previousTreeMap =  new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        List<Integer> list = new LinkedList<>();
        if(root==null)return list;
        helper(root,null);
        findInChild(target,list,K);
        findInParent(target,list,K);
        list.remove(target.val);
    return list;
    }

    private void findInChild(TreeNode target,List<Integer> list,int k){

        if(target==null)return;
        if(k==1){
            if(target.left!=null)list.add(target.left.val);
            if(target.right!=null)list.add(target.right.val);
        }else {
            findInChild(target.left,list,k-1);
            findInChild(target.right,list,k-1);
        }



    }


    private void findInChild(TreeNode target,List<Integer> list,int k,TreeNode noNode) {

        if (target == null) return;
        if (k == 1) {
            if (target.left != null && target.left != noNode) list.add(target.left.val);
            if (target.right != null && target.right != noNode) list.add(target.right.val);
        } else {
            if (target.left != null && target.left != noNode) findInChild(target.left, list, k - 1);
            if (target.right != null && target.right != noNode) findInChild(target.right, list, k - 1);
        }
    }

    private void findInParent(TreeNode target,List<Integer> list,int k){

        if(target==null)return;


        TreeNode temp = previousTreeMap.get(target);


            if(temp!=null){
                if(k==1)list.add(temp.val);
                else{
                    findInChild(temp,list,k-1,temp);
                    //findInChild(temp,list,k-1);
                    findInParent(temp,list,k-1);
                }
        }
    }

    private void helper(TreeNode root,TreeNode previousNode){
        if(root==null)return;
        previousTreeMap.put(root,previousNode);
        helper(root.left,root);
        helper(root.right,root);
    }


}