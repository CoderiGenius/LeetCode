package SevenZero;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution {
    public int climbStairs(int n) {


        int[] dp = new int[n+1];
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int num1 = n;
            int num2 = n;


//            for (int i = 1; i <=n ; i++) {
//                dp[0][i] = 1;
//            }
            dp[0] = 1;
            int i = 1;
            while(i<=n){
                if(i>=2){
                    dp[i] = dp[i-1]+dp[i-2];
                }else {
                    dp[i] = dp[i] + 1;
                }
                i++;
            }

        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(44));
    }
}
