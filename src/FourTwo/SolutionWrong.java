package FourTwo;

import java.util.*;

public class SolutionWrong {

    public int trap(int[] height) {

        int returnData1 = helper2(height);

//        List<Integer> list = new ArrayList<Integer>(height.length);
//        for (int i :
//                height) {
//            list.add(i);
//        }
//        Collections.reverse(list);
//        for (int i = 0; i < list.size(); i++) {
//            height[i] = list.get(i);
//        }
//        int returnData2 = helper2(height);
//
//        return Math.max(returnData1,returnData2);
        return returnData1;

    }

    private int helper2(int[] height){
        if(height==null||height.length==0){
            return 0;
        }
        int[] dp = new int[height.length];

        //Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int maxPosition = 0;
        for (int i = 0; i < height.length; i++) {
            if(i==0){
                dp[i] = 0;
                max = height[i];
                maxPosition = i;
                //map.put(i, height[0]);
            }
            else if(i==1){
                dp[i] = 0;
                if(max<height[i]){
                    max = height[i];
                    maxPosition = i;
                }
                //map.put(i,Math.max(map.get(i-1),height[i]));
            }
            else {
                if(height[i]!=0){
                    //map.put(i,Math.max(map.get(i-1),height[i]));

                    //int previousMax = map.get(i-1);
                    int square = 0;
                    if(max>height[i]){
                        square = height[i] * (i-maxPosition+1);
                        square = helper(height,maxPosition,i,height[i],square);
                        if(square!=0) {
                            dp[i] = dp[maxPosition] + square;
                            System.out.println("dp:" + Arrays.toString(dp) + "maxPostion:" + maxPosition);
                        }else {
                            dp[i] = dp[i-1];
                        }
                    }else {
                        square = max * (i-maxPosition+1);
                        square = helper(height,maxPosition,i,max,square);
                        if(square!=0) {
                            max = height[i];
                            dp[i] = dp[maxPosition] + square;
                            System.out.println("dp:" + Arrays.toString(dp) + "maxPostion:" + maxPosition);

                            maxPosition = i;
                        }else {
                            dp[i] = dp[i-1];
                            max = height[i];
                            maxPosition = i;
                        }
                    }


                }else {
                    dp[i] = dp[i-1];

                    //biggest[i] = biggest[i-1];
                }
            }
        }
        Arrays.parallelSort(dp);
        return dp[height.length-1];
    }
    private int helper(int[] height,int start,int end,int border,int square){
        System.out.println("in:"+start+" "+end+" "+border+" "+square);
        int initEnd = end;
        if(start>=end)return square;
        square = square -(2*(border));
        end--;
        while (end>start){
            if(height[end]<border)
            square = square - height[end];
            else {
                //square = square - border;
                return helper(height,end,initEnd,height[end],(initEnd-end+1)*height[end]);
            }
            end--;
        }
        System.out.println("out:"+start+" "+end+" "+border+" "+square);

        return square;
    }

    public static void main(String[] args) {
        //System.out.println(new SolutionOld().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new SolutionWrong().trap(new int[]{1,6,1,6,1,3,8,8,3,4,9,6,3,2,8,5,7}));
        //System.out.println(new SolutionOld().trap(new int[]{9,6,8,8,5,6,3}));

    }
}

