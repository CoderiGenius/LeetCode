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
        start++;
        while (end != start) {
            System.out.println("start:"+start+" end:"+end);
            if (num[end] > num[flag]) {
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

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7,8,9,0};

        QuickSort.sort(ints);

        Arrays.stream(ints).forEach(System.out::println);
    }
}
