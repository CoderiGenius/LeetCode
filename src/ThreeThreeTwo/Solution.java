package ThreeThreeTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    //Map<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {

        if(amount==0)return 0;
        Arrays.sort(coins);

        int[][] backPack = new int[coins.length][amount+1];



//        System.out.print("  ");
//        for (int i = 0; i < 12; i++) {
//            System.out.print(i+" ");
//        }
//        System.out.println("");
        for (int i = 0; i < coins.length; i++) {
            //System.out.print(coins[i]+" ");
            for (int j = 0; j <=amount; j++) {
                backPack[i][j] = helper(i,j,backPack,coins);
               // System.out.print(backPack[i][j]+" ");

            }
           // System.out.println("");
        }
        int returnValue = backPack[coins.length-1][amount];
        if(returnValue!=0)
        return backPack[coins.length-1][amount];
        else {
            return -1;
        }
    }

    private int helper(int coinsValue, int amount,int[][] backPack,int[] coins){
        //获得上一个硬币数量，如果本框无法达成，则沿用上一个数量
        int lastValue;
        if(coinsValue>0)
        lastValue = backPack[coinsValue-1][amount];
        else {
            lastValue = 0;
        }
        int newReturnValue = 1;
        //如果当前硬币值可以塞入背包，直接返回当硬币
        if(amount-coins[coinsValue]==0){
            return 1;
        }
        //如果当前硬币可以cover部分amount，则要找剩余部分
        if(amount-coins[coinsValue]>0){

            //如果剩余部分找不到
            int result =getter(coinsValue,amount-coins[coinsValue],backPack);
            if(result==0){
                return lastValue;
            }
            //如果剩余部分找得到，则看看上一个满足amount的数值和本次得出的哪个小
            //System.out.println("result:"+result+" last:"+lastValue);
            if(lastValue!=0)
            return Math.min(1+result,lastValue);
            else {
                return 1+result;
            }
            //return 1+result;
        }else {
            //如果当前硬币不能放入背包，cover过了，则直接返回上一个满足的数值
            return lastValue;
        }

    }
    private int getter(int coinsValue,int amount, int[][] backPack){
        int result = backPack[coinsValue][(amount)];
        //System.out.println(result);
        while (result==0 && coinsValue!=0){
            coinsValue = coinsValue-1;
            result = backPack[coinsValue][amount];
        }
        return result;

    }

}