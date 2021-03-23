package ThreeTwoTwo;

import java.util.Arrays;

/**
 * @author CoderiGenius
 * @version 2021/3/23 11:51 上午
 */
class Solution {
    public int coinChange(int[] coins, int amount) {

        if(amount==0||coins.length==0)return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < dp.length; i++) {
            for (int c :
                    coins) {
                if(c>i){
                   // dp[i] = 0;
                }else {
                    if(dp[i-c] == Integer.MAX_VALUE){
                        dp[i] = dp[i];
                    }else
                    dp[i] = Math.min(dp[i-c]+1,dp[i]);
                }
            }
        }
        if(dp[dp.length-1]<0||dp[dp.length-1]==Integer.MAX_VALUE){
            return -1;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.coinChange(new int[]{1,2,5},11));
//        System.out.println(solution.coinChange(new int[]{2},3));
        System.out.println(solution.coinChange(new int[]{186,419,83,408},6249));


    }
}