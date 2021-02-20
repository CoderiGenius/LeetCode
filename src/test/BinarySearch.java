package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(3);
        list.add(9);


        Integer[] integers = list.toArray(new Integer[0]);

        Arrays.sort(integers);
        System.out.println(Arrays.toString(integers));
        List<Integer> list1 = Arrays.asList(integers);
        System.out.println(binarySearch(list1,0,list.size()-1,2));
    }


    public static int binarySearch(List<Integer> list,int left,int right,Integer target){
        if(left>=right)return -1;
        int middle = (left+right)/2;
        //if(left==right-1 && !list.get(left).equals(target) && !list.get(right).equals(target))return -(middle+1);

        if(list.get(middle).equals(target))return middle;
        if(target<list.get(middle)){
           return binarySearch(list,left,middle-1,target);
        }else {
            return binarySearch(list,middle+1,right,target);
        }
    }
}
