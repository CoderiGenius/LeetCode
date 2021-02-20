package ThreeThree;

public class Solution {

    public int search(int[] nums, int target) {

        if(nums==null || nums.length<=0){
            return -1;
        }

        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left<=right){
            int middle = (left+right)/2;
            if(target== nums[middle]){
                return middle;
            }
            if(isAecSorted(nums,left,middle)){

                if(target<nums[middle] && target>=nums[left]){
                    right = middle-1;
                }else {
                    left = middle+1;
                }
            }else {
                if(target>nums[middle] && target<=nums[right]){
                    left = middle+1;
                }else {
                    right = middle-1;
                }
            }

        }
        return -1;
    }

    private boolean isAecSorted(int[] ints,int start,int end){
        if(ints[start]<=ints[end]){
            if(ints[start]<=ints[(start+end)/2]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4,5,6,7,8,1,2,3},8));
    }
}
