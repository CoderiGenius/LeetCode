package Inversions;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeSortList {

    public static List<Integer> sort(List<Integer> list){
        List<Integer> position = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            position.add(i);
        }
        System.out.println("s:"+position);
       return sort(list,position);
    }

    public static List<Integer> sort(List<Integer> list,List<Integer> position){

        if(list.size()==2){
            if(list.get(0)>list.get(1)){
                Integer integer = list.get(0);
                list.set(0,list.get(1));
                list.set(1,integer);

                integer = position.get(0);
                position.set(0,position.get(1));
                position.set(1,integer);
            }
            return list;
        }else if(list.size()<=1){
            return list;
        }
        List<Integer> newPosition1 = position.subList(0,position.size()/2);
        List<Integer> list1 = sort(list.subList(0,list.size()/2),newPosition1);
        List<Integer> newPosition2 = position.subList(position.size()/2,position.size());

        List<Integer> list2 = sort((list.subList((list.size()/2),list.size())),newPosition2);

        List<Integer> mergeList = merge(list1,list2,newPosition1,newPosition2);

        return mergeList;
    }
    private static List<Integer> merge(List<Integer> list1,List<Integer> list2,List<Integer> position1,List<Integer> position2){
        List<Integer> list = new LinkedList<>();
        List<Integer> allPosition = new LinkedList<>();
        int one = 0;
        int two = 0;
        while (one<list1.size() && two<list2.size()){
            if(list1.get(one)>list2.get(two)){
                list.add(list2.get(two));
                allPosition.add(position2.get(two));
                two++;
            }else {
                list.add(list1.get(one));
                allPosition.add(position1.get(one));
                one++;
            }
        }
        while (one<list1.size()){
            list.add(list1.get(one));
            allPosition.add(position1.get(one));
            one++;
        }
        while (two<list2.size()){
            list.add(list2.get(two));
            allPosition.add(position2.get(two));
            two++;
        }
        System.out.println(allPosition);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(sort(new LinkedList<>(Arrays.asList(5,2,6,0))));

//        System.out.println(sort(new LinkedList<>(Arrays.asList(7,5,4,2,2))));

//        System.out.println(sort(new LinkedList<>(Arrays.asList(5, 2, 6, 0, 7, 9, 3, 1))));
    }
}
