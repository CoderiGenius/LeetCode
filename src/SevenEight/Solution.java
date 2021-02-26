package SevenEight;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        if(nums==null||nums.length==0){
            return list;
        }
        helper(nums,new LinkedList<>(),list,0);
        return list;
    }

    private void helper(int[] nums,List<Integer> list,List<List<Integer>> returnList,int current){
        if(nums==null||nums.length==0||nums.length==current){
            returnList.add(new LinkedList<>(list));

            return;
        }

        //for (int i = current; i < nums.length; i++) {
            list.add(nums[current]);
            //returnList.add(new LinkedList<>(list));
            helper(nums,list,returnList,current+1);
            list.remove(list.size()-1);
            //returnList.add(new LinkedList<>(list));

            helper(nums,list,returnList,current+1);
       // }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsets(new int[]{1,2,3}));
    }


}