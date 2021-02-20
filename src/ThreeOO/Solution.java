package ThreeOO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    public int lengthOfLIS3(int[] nums){
//        //dp用于存储当前遇到的元素形成的上升子序列。
//        int[] dp = new int[nums.length];
//        int endIdx = 0;
//        //遍历原序列，将每一个num二分插入dp中。如果num比dp元素大，将num插到dp最后；否则用num覆盖第一个比它大的元素。
//        //遍历结束后，dp始终存储着比较小的元素（贪心），长度也与真实的最长上升子序列相同。
//        for(int num : nums){
//            //若num在dp中，返回下标；若num比dp元素小，返回-1；若num比dp元素大，返回-(endIdx+1)；若num可以插入dp，返回-(大于num的插入下标+1)
//            int loc = Arrays.binarySearch(dp, 0, endIdx, num);
//            if(loc < 0){
//                loc = -(loc + 1);
//            }
//            dp[loc] = num;
//            if(loc == endIdx){
//                endIdx++;
//            }
//        }
//        return endIdx;



//        int[] dp = new int[nums.length];
//
//        for (int i = 0; i < nums.length; i++) {
//
//                dp[i] = helper(nums,i);
//
//        }
//
//        System.out.println(Arrays.toString(dp));
//
//return 0;
        return helper(nums,0);
    }

    private int helper(int[] nums,int start){
        int[] temp = new int[nums.length];
        int current = 0;
        for (int i = start; i < nums.length; i++) {
            if(current==0){
                temp[current] = nums[i];
                current++;
            }
            else {
                if(nums[i]>temp[current-1]){
                    temp[current] = nums[i];
                    current++;
                }else {
                    int pos = Arrays.binarySearch(temp,0,current-1,nums[i]);
                    pos = -pos-1;
                    temp[pos] = nums[i];
                }
            }
        }
        return current;

    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,5,3,4,8};

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS3(ints));

        //System.out.println(Arrays.binarySearch(ints,9));


    }
}
