package SevenFourThree;

import java.util.*;

public class Solution {
    static int max;
   // static int nodes;
    public int networkDelayTime(int[][] times, int n, int k) {
        //nodes = 0;
        max = Integer.MIN_VALUE;
        if(times==null||times.length==0){
            return 0;
        }


       // Map<Integer, List<DisAndLength>> map = new HashMap<>();
        Map<Integer,Integer> pre = new HashMap<>();

        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        for (int i = 1; i <= n; i++) {
            pre.put(i,Integer.MAX_VALUE);
        }
        pre.put(k,1);
        dfs(graph,pre,k,0);
        //nodes++;


        for (Integer i :
                pre.values()) {
            if(i==Integer.MAX_VALUE)return -1;
            else max = Math.max(i,max);
        }

        return max;
    }

    public void dfs(Map<Integer, List<int[]>> graph,Map<Integer,Integer> pre, int node, int elapsed) {
        if (pre.containsKey(node) && elapsed >= pre.get(node)) return;
        pre.put(node, elapsed);
        if (graph.containsKey(node))
            for (int[] info: graph.get(node))
                dfs(graph,pre, info[0], elapsed + info[1]);
    }

    private void newHelper(Map<Integer,List<int[]>> map,Map<Integer,Integer> pre,int current,int length){
        if(length>pre.get(current))return;
        List<int[]> list = map.get(current);
        if(list==null || list.size()==0){
            return;
        }

        for (int[] ints:
             list) {
            if(pre.containsKey(ints[0]) ){
                if(pre.get(ints[0])>(length+ints[1])){
                    pre.put(ints[0],length+ints[1]);
                    newHelper(map,pre,ints[0],length+ints[1]);
                }

            }
            else {
                //nodes++;
                pre.put(ints[0],length+ints[1]);
                newHelper(map,pre,ints[0],length+ints[1]);
            }
        }
    }

    private void helper(Map<Integer,List<DisAndLength>>  map,Map<Integer,Integer> pre, int current,int length){
        //pre.putIfAbsent(current,length);

        List<DisAndLength> list = map.get(current);
        if(list==null){
//            max = Math.max(pre.get(current),max);
            return;
        }
        for (DisAndLength d :
                list) {
            if(pre.containsKey(d.dis) ){
                if(pre.get(d.dis)>(length+d.length)){
                    pre.put(d.dis,length+d.length);
                    helper(map,pre,d.dis,length+d.length);
                }

            }
            else {
                //nodes++;
                pre.put(d.dis,length+d.length);
                helper(map,pre,d.dis,length+d.length);
            }

        }


    }

    static class DisAndLength{
        int dis;
        int length;

        public DisAndLength(int dis, int length) {
            this.dis = dis;
            this.length = length;
        }

        @Override
        public String toString() {
            return "DisAndLength{" +
                    "dis=" + dis +
                    ", length=" + length +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[][] ints = new int[3][];
        ints[0] = new int[]{2,1,1};
        ints[1] = new int[]{2,3,1};
        ints[2] = new int[]{3,4,1};
       // ints[0] = new int[]{1,2,1};
//        ints[1] = new int[]{2,3,2};
//        ints[2] = new int[]{1,3,2};
        System.out.println(new Solution().networkDelayTime(ints,2,2));
//        ints[0] = new int[]{1,2,1};
//        ints[1] = new int[]{2,1,3};
////        ints[2] = new int[]{3,4,1};
//        System.out.println(new Solution().networkDelayTime(ints,2,2));
    }
}
