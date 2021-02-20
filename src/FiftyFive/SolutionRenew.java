package FiftyFive;

public class SolutionRenew {

    public boolean canJump(int[] nums) {

        if(nums==null || nums.length==0 ||nums.length==1){
            return true;
        }
        int[] dp = new int[nums.length];

        if(nums[nums.length-1]!=0)
            dp[nums.length-1] = 1;


        for (int i = nums.length-2; i >=0 ; i--) {
            for (int j = nums[i]; j >=0; j--) {
                if((i+j)>=(nums.length-1)){
                    dp[i] = 1;
                    break;
                }else if(dp[i+j]==1){
                    dp[i] = 1;
                    break;
                }
            }

        }
        return dp[0]==1;

    }

}
