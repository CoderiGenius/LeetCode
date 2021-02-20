package sort;

import java.util.Arrays;

public class InsertSort {

    public void sort(int[] nums){
        if(nums.length<=1){
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(nums[j]<nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
            }else {
                    break;
                }
        }
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,0};
//
        InsertSort insertSort = new InsertSort();
        insertSort.sort(ints);

        System.out.println(Arrays.toString(ints));

    }
}
