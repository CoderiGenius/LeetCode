package One262;

import java.util.*;

public class Solution {

    static int total = 0;

    public int maxSumDivThree(int[] nums) {

        Arrays.parallelSort(nums);
       
        Queue<Integer> list1 = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();

        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int result = nums[i] % 3;
            if(result==1)list1.add(nums[i]);
            if(result==2)list2.add(nums[i]);
            total += nums[i];
        }

        int result = total % 3;
        while(result!=0){


            if(result==1){
                if(list1.isEmpty() && list2.size()<2){
                    return 0;
                }
                int total1 = minus(list1,total);
                int total2 = minus(list2,minus(list2,total));
                total = Math.max(total1,total2);

            }
            if(result==2){
                if(list2.isEmpty() && list1.size()<2){
                    return 0;
                }
                int total1 = minus(list1,minus(list1,total));
                int total2 = minus(list2,total);
                total = Math.max(total1,total2);
            }


            result = total % 3;

        }


        return total;

    }

    private int minus(Queue<Integer> list,int total){
        if(list.isEmpty())return -1;
        total = total - list.poll();

        return total;
    }

    

    private void helper(int[] nums,int last,int currentTotal){
        if(last>=nums.length-1){
            return;
        }
        int temp = currentTotal + nums[last+1];
        if(temp%3==0){
            total = Math.max(total,temp);
            helper(nums,last+1,total);
        }else {
            helper(nums,last+1,total);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSumDivThree(new int[]{2,6,2,2,7}));
    }

}
