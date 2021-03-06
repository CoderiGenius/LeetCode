package OneOTwo;

import entity.TreeNode;

import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();

        if(root==null)return list;
        List<Integer> le = new LinkedList<>();
        le.add(root.val);
        list.add(le);

        Map<Integer,List<Integer>> map = new HashMap<>();
        helper(root,map,1);

        for (Integer integer
                :map.keySet()
             ) {
            list.add(map.get(integer));
        }



            return list;
    }
    private void helper(TreeNode root, Map<Integer,List<Integer>> list, int level){
        if(root==null)return;
        List<Integer> le = new LinkedList<>();
        if(root.left!=null){
            le.add(root.left.val);

            helper(root.left,list,level+1);
        }
        if(root.right!=null){
            le.add(root.right.val);

            helper(root.right,list,level+1);
        }
       List<Integer> list1 = list.get(level);
        if(list1==null){
            list.put(level,le);
        }else {
            list1.addAll(le);
        }
    }
}
