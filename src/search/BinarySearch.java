package search;


import java.util.Arrays;

/**
 * 二分搜索
 */
public class BinarySearch {


    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums,int target){
        if(nums.length<1){
            return -1;
        }

       return helper(0,nums.length-1,nums,target);
    }


    /**
     * 找不到返回-1
     * @param start
     * @param end
     * @param nums
     * @param target
     * @return
     */
    private static int helper(int start, int end, int[] nums,int target) {
        if(start==end || start==end-1){
            if(target==nums[start])return start;
            else if ((target==nums[end]))return end;
            else {
                return -1;
            }
        }

        if(target<nums[start] || target>nums[end]){
            return -1;
        }else if(target>=nums[start] && target<=nums[(start+end)/2]){
            //System.out.println("1start:"+start+" end:"+end);
            return helper(start,(start+end)/2,nums,target);
        }else {
            //System.out.println("start:"+start+" end:"+end);
            return helper((start+end)/2,end,nums,target);
        }
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6};
        Arrays.stream(ints).sorted().forEach(System.out::println);
       System.out.println(BinarySearch.search(ints,7));
    }
}
