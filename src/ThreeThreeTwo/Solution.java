package ThreeThreeTwo;

import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount+1];

        Arrays.fill(amounts,amount+1);
        amounts[0] = 0;
        for (int c :coins
             ) {
        for (int i = c; i <amounts.length ; i++) {
            amounts[i] = Math.min(amounts[i],amounts[i-c]+1);
        }
        }

        if(amounts[amount]==amount+1){
            return -1;
        }else {
            return amounts[amount];
        }
    }
}