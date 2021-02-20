package FiveThree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionDP {
    public int maxSubArray(int[] nums) {

       if(nums==null || nums.length==0){
           return 0;
       }
       if(nums.length==1){
           return nums[0];
       }
       int[] dp = new int[nums.length];
       dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new SolutionDP().maxSubArray(new int[]{-1,-2}));
    }
}
