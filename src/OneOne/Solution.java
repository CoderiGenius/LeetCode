package OneOne;

class Solution {
    public int waysToChange(int n) {

        long[] amounts = new long[n+1];
        int[] coins = {1,5,10,25};
        amounts[0] = 0;

        for (int i:
             coins) {
            for (int j = i; j <amounts.length ; j++) {
//                amounts[j] = Math.max(amounts[j],amounts[j-i]+1);
               // int possible = 0;
                if(amounts[j-i]!=0){
                    amounts[j]++;
                }
            }
        }
        long returnNumber = amounts[n] % 1000000007;
        return (int) returnNumber;
    }
}
