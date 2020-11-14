package sort;

import search.BinarySearch;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(int[] num){

        for (int i = 0; i < num.length; i++) {
            for (int j = i; j < num.length-1; j++) {
                if(num[i]<num[j+1]){
                    System.out.println("i:"+num[i]+" j:"+num[j+1]);
                    int temp = num[i];
                    num[i] = num[j+1];
                    num[j+1] = temp;
                }
//                else{
//
//                }
            }
        }
        Arrays.stream(num).forEach(System.out::println);
    }


    public static void main(String[] args) {
        int[] ints = new int[]{1,9,3,4};
        //Arrays.stream(ints).sorted().forEach(System.out::println);
        BubbleSort.sort(ints);
    }
}
