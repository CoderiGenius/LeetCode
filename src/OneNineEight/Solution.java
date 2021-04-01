package OneNineEight;

/**
 * @author CoderiGenius
 * @version 2021/3/31 12:13 上午
 */
public class Solution {
//    public int rob(int[] nums) {
//
//        if(nums.length==2){
//            return Math.max(nums[0],nums[1]);
//        }
//        if(nums.length==1){
//            return nums[0];
//        }
//        if(nums.length==0){
//            return 0;
//        }
//
//        int[] dp = new int[nums.length];
//
//
//        dp[0] = nums[0];
//        dp[1] = nums[1];
//        dp[2] = nums[0]+nums[2];
//        for (int i = 3; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-3]+nums[i]);
//        }
//
//        return Math.max(dp[nums.length-1],dp[nums.length-2]);
//
//
//    }


    public int rob(int[] nums) {

        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return 0;
        }

        int steal = nums[0];
        int notSteal = 0;
        for (int i = 1; i < nums.length; i++) {

            if(i==1){
                steal = nums[1];
                notSteal = nums[0];
            }
            else {

                int temp = notSteal;
                notSteal = Math.max(notSteal , steal);
                steal = temp+nums[i];
            }
        }

        return Math.max(steal,notSteal);


    }

    private int getPreTwoBiggest(int position,int[] nums,int[] dp){
        if(position==0 || position==1){
            return nums[position];
        }
        if(position==2){
            return getPreTwoBiggest(0,nums,dp)+nums[position];
        }
        return Math.max(getPreTwoBiggest(position-2,nums,dp),getPreTwoBiggest(position-3,nums,dp))+nums[position];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,7,9,3,1}));
    }
}
