package OneFive;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new LinkedList<>();
        if(nums==null || nums.length==0){
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i <nums.length-1 ; i++) {

            while (i>0 && i<nums.length-1 && nums[i]==nums[i-1]){
                i++;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum>0){
                    right--;
                }else if(sum<0){
                    left++;
                }else {
                    List<Integer> list1 = new LinkedList<>();
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
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(new SolutionOld().threeSum(new int[]{-1,-1,0,1}));
        System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));

    }
}
