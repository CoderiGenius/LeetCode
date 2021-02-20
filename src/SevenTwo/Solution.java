package SevenTwo;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class Solution {

    static int max = 0;
    public int minDistance(String word1, String word2) {



        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < word1.length()+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                int temp = Math.min(dp[i-1][j],dp[i][j-1]);
                temp = Math.min(temp,dp[i-1][j-1])+1;
                if(word1.charAt(i-1)==word2.charAt(j-1)){

                    dp[i][j] = Math.min(dp[i-1][j-1],temp);
                }else {
                    dp[i][j] = temp;
                }
            }

//            int total = 0;
//            for (int j = 0; j < word2.length(); j++) {
//                total+=dp[i][j];
//            }
//            max = Math.min(total,max);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));

        }

        return dp[word1.length()][word2.length()];

    }

    public static void main(String[] args) {
       // System.out.println(new Solution().minDistance("intention","execution"));
        System.out.println(new Solution().minDistance("horse","ros"));

    }

//    private void helper(List<String> word1,List<String> word2,int left,int right,int lastValue){
//
//        while(left>=0){
//            if(word1.get(left).equals(word2.get(left))){
//                lastValue++;
//                left--;
//            }else {
//                String oldValue = word1.get(left);
//                //replace
//                word1.set(left,word2.get(left));
//                left--;
//                lastValue++;
//                helper(word1,word2,left,right,lastValue);
//                word1.set(left+1,oldValue);
//                //insert
//
//                helper();
//            }
//        }
//
//    }
}
