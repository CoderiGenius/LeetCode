package SevenFourThree;

import java.util.*;

public class HeapSolution {


    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge : graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d + d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand : dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }

    public static void main(String[] args) {
        int[][] ints = new int[3][];
        ints[0] = new int[]{1,2,1};
        ints[1] = new int[]{2,3,2};
        ints[2] = new int[]{1,3,2};

        System.out.println(
                new HeapSolution().networkDelayTime(ints,3,1)
        );
    }
}


