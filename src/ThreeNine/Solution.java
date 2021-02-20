package ThreeNine;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> list = new LinkedList<>();
        if(candidates==null ||candidates.length==0){
            return list;
        }
        Arrays.parallelSort(candidates);
        helper(candidates,target,0,new LinkedList<>(),list,0);
        return list;
    }


    public void helper(int[] candidates, int target, int total, List<Integer> list, List<List<Integer>> all,int start){

        for (int i = start; i < candidates.length; i++) {
            int sum = (total+candidates[i]);
            if(sum==target){
//System.out.println(list +" toatl:"+total+" c:"+candidates[i]);
              List<Integer> list1 = new LinkedList<>(list);
                list1.add(candidates[i]);
                all.add(list1);


                helper(candidates,target,total,list1,all,i+1);

            }else if(sum<target){
                list.add(candidates[i]);
                helper(candidates,target,sum,list,all,i);
                list.remove(list.size()-1);
            }else{
                //helper(candidates,target,total,list,all,start+1);
                break;
            }

        }
    }
    private List<Integer> setToList(Set<Integer> set){
        List<Integer> list = new LinkedList<>(set);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2,3,6,7},7));
    }
}
