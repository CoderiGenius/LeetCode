package OneEight;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> list = new LinkedList<>();
        if(nums==null || nums.length==0){
            return list;
        }
        Arrays.parallelSort(nums);

        for (int j = 0; j < nums.length-1; j++) {

        while (j>0 && j<nums.length-1 && nums[j]==nums[j-1]){
            j++;
        }
        for (int i = j+1; i <nums.length-1 ; i++) {

            while (i>j+1 && i<nums.length-1 && nums[i]==nums[i-1]){
                i++;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right] + nums[j];
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else {
                    List<Integer> list1 = new LinkedList<>();
                    list1.add(nums[j]);
                    list1.add(nums[i]);
                    list1.add(nums[left] );
                    list1.add(nums[right]);
                    list.add(list1);

                    while (right>left && nums[right]==nums[right-1]){
                        right--;
                    }
                    while (right>left && nums[left]==nums[left+1]){
                        left++;
                    }
                    right--;
                    left++;
                }
            }
        }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{1,0,-1,0,-2,2},0));
    }
}
