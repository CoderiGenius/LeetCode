package ThreeFour;

public class Solution {

    public int[] searchRange(int[] nums, int target) {

        int[] ints = new int[]{-1,-1};
        if(nums==null || nums.length<=0){
            return ints;
        }

        int left = 0;
        int right = nums.length-1;

        while (left<=right){
            int middle = (left+right)/2;

            if(target==nums[middle])return checkLeftAndRight(nums,middle, target);

            if(target<nums[middle]){
                right = middle - 1;
            }
            if(target>nums[middle]){
                left = middle+1;
            }
        }
        return ints;
    }

    private int[] checkLeftAndRight(int[] ints,int point,int target){

        int toLeft = point;
        int toRight = point;
        while (toLeft>0){
            if(target==ints[toLeft-1]){
                toLeft--;
            }else {
                break;
            }
        }
        while (toRight<ints.length-1){
            if(target==ints[toRight+1]){
                toRight++;
            }else {
                break;
            }
        }
        return new int[]{toLeft,toRight};
    }
}
