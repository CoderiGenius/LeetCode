package Inversions;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int []arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int []b = new int[arr.length];
        int []c = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            b[i] = i;
        }
        System.out.println(Arrays.toString(b));
        sort(arr,0,arr.length-1,temp,b,c);
        System.out.println(Arrays.toString(b));

    }
    private static void sort(int[] arr,int left,int right,int []temp,int[] b,int[] c){
        if(left<right){
            int mid = (left+right)/2;
            sort(arr,left,mid,temp,b,c);//左边归并排序，使得左子序列有序
            sort(arr,mid+1,right,temp,b,c);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp,b,c);//将两个有序子数组合并操作
        }
    }
    private static void merge(int[] arr,int left,int mid,int right,int[] temp,int[] b,int[] c){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
                c[t-1] = b[i-1];
            }else {
                temp[t++] = arr[j++];
                c[t-1] = b[j-1];
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
            c[t-1] = b[i-1];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
            c[t-1] = b[i-1];
        }
        t = 0;
        System.out.println("c"+Arrays.toString(c));
        System.out.println("temp"+Arrays.toString(temp));
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
            //b[left-1] = c[t-1];
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{5,2,6,0};
        MergeSort.sort(ints);
        //System.out.println(Arrays.toString(ints));
    }

}
