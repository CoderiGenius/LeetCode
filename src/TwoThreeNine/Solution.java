package TwoThreeNine;

import java.util.*;

/**
 * @author CoderiGenius
 * @version 2021/4/5 12:19 下午
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new LinkedList<>();
        if(nums.length==0)return new int[0];
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>(k,new Comparator<Integer[]>() {
            public int compare(Integer[] pair1, Integer[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {

            priorityQueue.offer(new Integer[]{nums[i],i});
        }
        list.add(priorityQueue.peek()[0]);

        for(int i=k;i<nums.length;i++){

            if(i!=0){
//                priorityQueue.remove(nums[i-k]);
                addInToMap(map,nums[i-k]);
            }

                //ints[j] = nums[i+j];

            priorityQueue.offer(new Integer[]{nums[i],i});

            //Arrays.sort(ints);
            //list.add(ints[ints.length-1]);
            //checkTop(map,priorityQueue);
            Integer[] integers = null;
            while(!priorityQueue.isEmpty()) {
                 integers= priorityQueue.peek();
                if (integers[1] <= (i - k)) {
                    priorityQueue.poll();
                }else {
                    break;
                }
            }
            list.add(integers[0]);
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private void addInToMap(Map<Integer,Integer> map,int i){
        if(map.containsKey(i)){
            map.put(i,map.get(i)+1);
        }else {
            map.put(i,1);
        }
    }

    private void checkTop(Map<Integer,Integer> map,PriorityQueue<Integer> priorityQueue){
        Integer integer = priorityQueue.peek();
        if(map.containsKey(integer)){
            int length = map.get(integer);
            for (int i = 0; i < length; i++) {
                priorityQueue.poll();
            }
            map.remove(integer);
            checkTop(map,priorityQueue);
        }else {
            return;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new SolutionOld().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1,-1}, 1)));
        System.out.println(Arrays.toString(new Solution().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));

    }
}
