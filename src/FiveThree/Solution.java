package FiveThree;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int maxSubArray(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }

        int max = Integer.MIN_VALUE;
        List<Integer> maxs = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
//            if(max==nums[i]){
//                maxs.add(i);
//            }
//            if(max<nums[i]){
//                maxs.clear();
//                max = nums[i];
//                maxs.add(i);
//            }
            maxs.add(i);
        }
        return toLeftAndRight(maxs,nums);
    }

    private int toLeftAndRight(List<Integer> maxs,int[] nums){

        int total = Integer.MIN_VALUE;
        int temp = Integer.MIN_VALUE;
        for (Integer i :
                maxs) {
            temp = Math.max(toLeft(i,nums),toRight(i,nums));
            total = Math.max(total,temp);
        }
        return total;
    }
    private int toLeft(int max,int[] nums){
        int total = Integer.MIN_VALUE;

        int temp = 0;
        for (int i = max; i >=0 ; i--) {
            temp = temp + nums[i];
            total = Math.max(total,temp);


        }
        return total;
    }
    private int toRight(int max,int[] nums){

        int total = Integer.MIN_VALUE;

        int temp = 0;
        for (int i = max; i <nums.length ; i++) {
            temp = temp + nums[i];
            total = Math.max(total,temp);


        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
