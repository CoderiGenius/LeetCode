package sort;

public class InsertSort {

    public void sort(int[] nums){
        if(nums.length<=1){
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]<nums[j]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        for (int i = 0; i <nums.length ; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
//        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,0};
//
//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(ints);
        int i=0;
        String s = ". ";
        System.out.println(new StringBuilder(i).append(s));

    }
}
