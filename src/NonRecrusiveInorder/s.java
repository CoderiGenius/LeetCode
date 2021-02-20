package NonRecrusiveInorder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s {


    public static int fountainActivation(List<Integer> a) {
        // Write your code here

        int[] fountainNumber = new int[a.size()];
        int[] fountainNumberToRight = new int[a.size()];
        Arrays.fill(fountainNumberToRight,65536 );
        Arrays.fill(fountainNumber,65536);
        fountainNumber[0] = 1;
        fountainNumberToRight[a.size()-1] = 1;

        for (int j = 1; j < a.size(); j++) {


            findoutEachPositionFountainNumber(fountainNumber, j, a);
            //findoutEachPositionFountainNumberToRight(fountainNumberToRight, j, a);

        }
        for (int i = a.size()-2; i >=0 ; i--) {
            findoutEachPositionFountainNumberToRight(fountainNumberToRight, i, a);

        }
        System.out.println(fountainNumberToRight[0] +" " +fountainNumber[a.size()-1]);
        return fountainNumberToRight[0]+fountainNumber[a.size()-1];

    }
    private static void findoutEachPositionFountainNumber(int[] fountainNumber,int current,List<Integer> a){
        fountainNumber[current] = Math.min(fountainNumber[getMin(a, current)-1]+1,fountainNumber[current-1]+1);
    }



    private static void findoutEachPositionFountainNumberToRight(int[] fountainNumber,int current,List<Integer> a){
        fountainNumber[current] = Math.min(fountainNumber[getMax(a, current)-1]+1,fountainNumber[current+1]+1);
    }

    private static int getMax(List<Integer> a,int current){
        System.out.println("getMax："+Math.min(current+a.get(current), a.size())+" current："+current);

        return Math.max(current+1-a.get(current), 1);
    }
    private static int getMin(List<Integer> a,int current){
        System.out.println("getMin："+Math.min(current+a.get(current), a.size())+" current："+current);

        return Math.min(current+1+a.get(current), a.size());
    }
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(s.fountainActivation(list));
    }
}


