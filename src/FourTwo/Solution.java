package FourTwo;

import java.util.Arrays;

public class Solution {

    public int trap(int[] height) {

        if(height==null||height.length==0){
            return 0;
        }

       int[] left = new int[height.length];
        int[] right = new int[height.length];
int length = 0;
        left[0] = height[0];
        for (int i = 1; i <height.length ; i++) {
            left[i] = Math.max(height[i],left[i-1]);
        }
        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0; i--) {
            right[i] = Math.max(height[i],right[i+1]);
        }

        for (int i = 0; i < height.length; i++) {
            length += Math.min(left[i],right[i])-height[i];
        }
        return length;

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
        //System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Solution().trap(new int[]{1,6,1,6,1,3,8,8,3,4,9,6,3,2,8,5,7}));
        //System.out.println(new Solution().trap(new int[]{9,6,8,8,5,6,3}));

    }
}

