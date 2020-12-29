package OneOneThree;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> totalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int currentSum = 0;


        if(root==null){
            return totalList;
        }

        list.add(root.val);
        helper(totalList,list,root,currentSum,sum);
        return totalList;
    }

    public boolean helper(List<List<Integer>> totalList, List<Integer> list, TreeNode root,int currentSum,int sum){
        if((currentSum+root.val)>sum){
            return false;
        }
        if((currentSum+root.val)==sum){
            System.out.println(list);
            totalList.add(new ArrayList<>(list));
            return true;
        }
        if((currentSum+root.val)<sum){
            if(root.left!=null){
                //System.out.println(root.left.val);
                list.add(root.left.val);
                boolean left = helper(totalList,list,root.left,currentSum+root.val,sum);
                list.remove(list.size()-1);
            }
            if(root.right!=null){
                list.add(root.right.val);
                helper(totalList,list,root.right,currentSum+root.val,sum);
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
