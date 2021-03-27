package OneTwoOne;

/**
 * @author CoderiGenius
 * @version 2021/3/24 3:49 下午
 */
public class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;
        int min = Integer.MAX_VALUE;

        if(prices.length<=1){
            return max;
        }
        int[] dp = new int[prices.length];
        dp[prices.length-1] = prices[prices.length-1];
        for (int i = prices.length-2; i >0 ; i--) {
            dp[i] = Math.max(dp[i+1],prices[i]);
        }
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i]<min){
                max = Math.max(dp[i+1]-prices[i],max);
                min = prices[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
