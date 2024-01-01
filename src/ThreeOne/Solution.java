package ThreeOne;

import java.util.*;

public class Solution {

    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length<=1){
            return;
        }
        int last = nums[nums.length-1];
        int target = -1;
        boolean changed = false;
       a:for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i-1]<last){
                target = i-1;
                for (int j = nums.length-1; j >=0 ; j--) {
                    if(nums[j]>nums[target]){
                        swap(nums,j,target);
                        changed = true;
                        break a;
                    }
                }
            }else {
                last = nums[i-1];
            }
        }
        if(!changed){
            Arrays.parallelSort(nums);
        }else {
            reverse(nums,target+1);
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] ints,int a,int b){
        int temp = ints[a];
        ints[a] = ints[b];
        ints[b] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }



    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{1,3,2});

       // System.out.println(Arrays.toString(new SolutionOld().reverse(new int[]{1,2,3,4},0)));
    }
}
