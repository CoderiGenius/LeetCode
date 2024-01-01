package TwoZeroSeven;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author CoderiGenius
 * @version 2021/4/1 9:21 下午
 */
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0||prerequisites[0].length==0){
            return true;
        }

        //用来储存课程限制，key是预选课程 value是想修的课程，如[0,1]则key就是1 value就是0
        Map<Integer, List<Integer>> map = new HashMap<>();
        //用来储存当前有向图走过的路径
        Map<Integer,Boolean> passed = new HashMap<>();
        //用来缓存结果，节省时间
        Map<Integer,Boolean> result = new HashMap<>();

        //把prerequisites中的内容存到map中
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.get(prerequisite[1]);
            if (list != null) {
                list.add(prerequisite[0]);
            } else {
                list = new LinkedList<>();
                list.add(prerequisite[0]);
            }
            map.put(prerequisite[1], list);
        }

        //挨个遍历prerequisites中各个限制，一旦有不符合要求的限制（即有环）则立刻返回false
        for (int[] prerequisite : prerequisites) {
            if (!check(prerequisite[1], map, passed, result)) {
                return false;
            }

        }
        return true;
    }
    private boolean check(int key,Map<Integer,List<Integer>> map,Map<Integer,Boolean> passed2,Map<Integer,Boolean> result){

        //检查缓存，节省时间
        if(result.containsKey(key))return true;

        //检查当前课程是否是其他课程的预选课程
        List<Integer> value = map.get(key);
        if(value==null){
            result.put(key,true);
            return true;
        }
        //检查当前课程是否走过，如果走过说明有环，则false
        if(passed2.containsKey(key)){
            return false;
        }
        //当前课程没走过，所以标记为走过
        passed2.put(key,true);

        //分别遍历当前预选课程的"所影响课程"list，来看看"所影响课程"是否也是预选课程
        for (Integer i :
                value) {
            if(!check(i,map,passed2,result)){
                return false;
            }
        }

        /*
         * 每次检查完路径之后，都把标记走过的路径清空
         * 重点：因为每次都从一个不同的开头开始走，所以如果不清空可能遇到经过同一节点的无环图却返回false的情况，举例：
         * 1    2
         *  \  /
         *   3
         *   ｜
         *   4
         *
         *   如果走1->3->4后不清空passed又走2->3->4的话，会认为3节点走过了而返回false，所以在走完1->3->4后应该清空passed
         */
        passed2.remove(key);
        //缓存结果，加快速度
        result.put(key,true);
        return true;

    }

//7
//        [[1,0],[0,3],[0,2],[3,2],[2,5],[4,5],[5,6],[2,4]]
    public static void main(String[] args) {
        int[][] ints = new int[8][2];
//        ints[0] = new int[]{0,2};
//        ints[1] = new int[]{1,2};
//        ints[2] = new int[]{2,0};
        ints[0] = new int[]{1,0};
        ints[1] = new int[]{0,3};
        ints[2] = new int[]{0,2};
        ints[3] = new int[]{3,2};
        ints[4] = new int[]{2,5};
        ints[5] = new int[]{4,5};
        ints[6] = new int[]{5,6};
        ints[7] = new int[]{2,4};
        System.out.println(new Solution().canFinish(3,ints));
    }
}
