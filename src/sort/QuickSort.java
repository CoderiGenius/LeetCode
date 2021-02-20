package sort;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    public static void sort(int[] num) {

        helper(num, 0, num.length - 1);
    }

    private static void helper(int[] num, int start, int end) {

        if (start >= num.length || end <= 0 || start >= end) {
            return;
        }

        int startSave = start;
        int endSave = end;

        int flag = start;
        //start++;
        while (end != start) {
            System.out.println("start:"+start+" end:"+end);
            if (num[end] >= num[flag]) {
                //System.out.println("end:"+end--);
                end--;
            } else if (num[start] < num[flag]) {
                //System.out.println("start:"+start++);
                start++;
            }
            if (num[end] <= num[flag] && num[start] >= num[flag]) {
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
            }
        }
        int temp = num[start];
        num[start] = num[flag];
        num[flag] = temp;


        System.out.println("start1:" + startSave + " end:" + (start - 1));
        helper(num, startSave, start - 1);

        System.out.println("start2:" + (start + 1) + " end:" + endSave);
        helper(num, (start) + 1, endSave);


    }

    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        int left = leftIndex;
        int right = rightIndex;
        //待排序的第一个元素作为基准值
        int key = arr[left];

        //从左右两边交替扫描，直到left = right
        while (left < right) {
            while (right > left && arr[right] >= key) {
                //从右往左扫描，找到第一个比基准值小的元素
                right--;
            }

            //找到这种元素将arr[right]放入arr[left]中
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                //从左往右扫描，找到第一个比基准值大的元素
                left++;
            }

            //找到这种元素将arr[left]放入arr[right]中
            arr[right] = arr[left];
        }
        //基准值归位
        arr[left] = key;
        //对基准值左边的元素进行递归排序
        quickSort(arr, leftIndex, left - 1);
        //对基准值右边的元素进行递归排序。
        quickSort(arr, right + 1, rightIndex);
    }

    public static void main(String[] args) {
        //int[] ints = new int[]{6,1,2,7,9,3,4,5,10,8};
        int[] ints = new int[]{2,0,2,1,1,0};

        QuickSort.sort(ints);
        //quickSort(ints,0,ints.length-1);
        Arrays.stream(ints).forEach(System.out::println);
    }
}
