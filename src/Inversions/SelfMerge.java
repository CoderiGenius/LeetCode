package Inversions;

import java.util.Arrays;

public class SelfMerge {

    public static void main(String[] args) {
        int[] ints =new int[]{5,2,6,0,7,9,3,1};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
    public static void sort(int[] sort){
        int n = sort.length;
        sort(sort,0,sort.length-1);
    }
    private static void sort(int[] ints,int start,int end){
        if((end-start)==2){
            if(ints[start]>ints[end]){
                swap(ints,start,end);
            }
            return;
        }else if ((end-start)<=1)return;
        sort(ints,start,(start+end)/2);
        sort(ints,((start+end)/2)+1,end);
        System.out.println(Arrays.toString(ints)+"s");
        merge(ints,start,(start+end)/2,end);

    }

    private static void merge(int[] ints,int start,int middle,int end){
        int leftStart = start;
        int leftEnd = middle;
        int rightStart = middle+1;
        int rightEnd = end;
        int[] temp = new int[ints.length];
        int i = leftStart;
        while (leftStart<=leftEnd && rightStart<=rightEnd){
            if(ints[leftStart]<ints[rightStart]){
                temp[i] = ints[leftStart];
                i++;
                leftStart++;
            }else {
                temp[i] = ints[rightStart];
                i++;
                rightStart++;
            }
        }
        while(rightStart<=rightEnd){
            temp[i] = ints[rightStart];
            i++;
            rightStart++;
        }
        while (leftStart<leftEnd){
            temp[i] = ints[leftStart];
            i++;
            leftStart++;
        }
        System.out.println(Arrays.toString(temp));
        for (int j = start; j <end ; j++) {
            ints[j] = temp[j];
        }
    }

    private static void swap(int[] ints,int left,int right){
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }
}
