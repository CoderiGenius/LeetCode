package ThreeZeroNine;

import java.util.Arrays;

/**
 * @author CoderiGenius
 * @version 2021/4/8 3:23 上午
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        if(prices.length<=1){
            return 0;
        }
        //0 啥也不做  1 买  2卖
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for(int i=1;i<prices.length;i++){
            //昨天卖了，今天冷静--》0
            //昨天买了，今天可以卖--》2 可以不卖--》0
            //昨天啥也没做，今天可继续啥也没做--》0，也可以买--》1，也可以取前天买了今天卖--》2

            //今天的啥也没做取 昨天卖了的值、昨天啥也没做的值、昨天买的值
            //今天的买了，取昨天啥也没做的值减今天的price、还有昨天买的值
            //今天的卖了，取昨天的买了，和前天的买了

            dp[i][0] = Math.max(Math.max(dp[i-1][2],dp[i-1][1]),dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
            int yesBuyTodaySell = prices[i]+dp[i-1][1];
            int beforeYesBuyTodaySell = 0;
            if(i>1){
                 beforeYesBuyTodaySell= prices[i] + dp[i-2][1];
            }
            dp[i][2] = Math.max(yesBuyTodaySell,beforeYesBuyTodaySell);
        }
        //System.out.println(Arrays.toString(dp));


    return Math.max(Math.max(dp[dp.length-1][0],dp[dp.length-1][1]),dp[dp.length-1][2]);
    }

//    private int getValue(int position,int[][] dp){
//        if(position<0)return 0;
//        return dp[position];
//    }

    public static void main(String[] args) {

        System.out.println(new Solution().maxProfit(new int[]{6,1,3,2,4,7}));

        System.out.println(new Solution().maxProfit(new int[]{1,2,3,0,2}));
    }
}
