package FiveSix;

import java.util.*;

public class Solution {

    public int[][] merge(int[][] intervals) {



        if(intervals.length==0){
            return new int[intervals.length][];
        }

        List<List<Integer>> list = new LinkedList<>();

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        for (int[] i :
                intervals) {
            priorityQueue.offer(i);
        }

        while (!priorityQueue.isEmpty()){
            int[] ints = priorityQueue.poll();
            int left = ints[0];
            int right = ints[1];
            while (!priorityQueue.isEmpty()){
                int[] ints1 = priorityQueue.peek();
                if(right>=ints1[0] ){
                    if(right<ints1[1])right = ints1[1];
                    priorityQueue.poll();
                }else {
                    break;
                }
            }
            List<Integer> list1 = new LinkedList<>();
            list1.add(left);
            list1.add(right);
            list.add(list1);
        }


        int[][] result = new int[list.size()][2];
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            for (int j = 0; j < temp.size(); j++) {
                //System.out.println(i+" "+j+" "+temp.size());
                result[i][j]
                        = temp.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] ints = new int[2][];
//        ints[0] = new int[]{1,3};
//        ints[1] = new int[]{2,6};
        ints[0] = new int[]{1,4};
        ints[1] = new int[]{0,4};
//        ints[2] = new int[]{8,10};
//        ints[3] = new int[]{15,18};
        System.out.println(Arrays.deepToString(new Solution().merge(ints)));
    }
}
