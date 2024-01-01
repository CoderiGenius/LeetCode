package TwoOneFive;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author CoderiGenius
 * @version 2021/4/2 2:23 上午
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1+o2;
            }
        });
        for (int i:nums){
            priorityQueue.offer(i);
        }
        for (int i = 0; i < k-1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
