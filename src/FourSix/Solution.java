package FourSix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        if(nums==null || nums.length==0){
            return list;
        }
        Arrays.parallelSort(nums);

        List<Integer> list1 = new ArrayList<>();
        for (int i :
                nums) {
            list1.add(i);
        }
        list.add(new ArrayList<>(list1));
        helper(list1,list);
        return list;
    }

    private void helper(List<Integer> list,List<List<Integer>> all){
        Integer target = null;
        Integer end= null;
        for (int i = list.size()-1; i >0 ; i--) {
            if(list.get(i)>list.get(i-1)){
                target = i-1;
                break;
            }
        }


        if(target==null)return;
        for (int i = list.size()-1; i >target ; i--) {
            if(list.get(target)<list.get(i)){
                end = i;
                Integer temp = list.get(target);
                //list.remove(target);
                list.set(target,list.get(i));
                //list.remove(i);
                list.set(i,temp);
                break;
            }
        }

        target++;
        end = list.size()-1;
        while(target<end){
            Integer temp = list.get(target);
            //list.remove(target);
            list.set(target,list.get(end));
            //list.remove(end);
            list.set(end,temp);
            target++;
            end--;
        }


        all.add(new ArrayList<>(list));
        helper(list,all);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1}));
    }

}
