package LakeTech;

import java.util.*;

/**
 * @author CoderiGenius
 * @version 2021/3/16 1:29 上午
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(connectedSum(8,new LinkedList<>(Arrays.asList("8 1", "5 8", "7 3", "8 6"))));
        System.out.println(connectedSum(4,new LinkedList<>(Arrays.asList("1 2", "1 4"))));
        System.out.println(connectedSum(16,new LinkedList<>(Arrays.asList("6 11", "9 5","11 9","15 9","13 15","12 14","15 16","1 16"))));

    }



    public static int connectedSum(int n, List<String> edges) {

        int sum = 0;
        if(n==0||edges.isEmpty()){
            return sum;
        }
        Map<String,TreeNode> map = new HashMap<>();
        Map<String,TreeNode> headMap = new HashMap<>();
        Map<String,String> nodeMap = new HashMap<>();
        Map<String,String> went = new HashMap<>();
        for (String s :
                edges) {
            String[] strings = s.split(" ");
            TreeNode treeNode = map.get(strings[0]);
            TreeNode childNode = map.get(strings[1]);

            if(treeNode==null){
                treeNode = new TreeNode(strings[0]);
            }

            if(childNode==null){
                childNode = new TreeNode(strings[1]);
            }
            treeNode.list.add(childNode);
            childNode.list.add(treeNode);

            map.put(strings[0],treeNode);
            map.put(strings[1],childNode);
            //check head list
//            if(nodeMap.get(strings[0])==null)headMap.putIfAbsent(strings[0], treeNode);
//
//            TreeNode kidHead = headMap.get(strings[1]);
//            if(kidHead!=null){
//                headMap.remove(strings[1]);
//            }
//            nodeMap.put(strings[1],strings[1]);


        }


        for (String s :map.keySet()
        ) {
            if(went.size()==map.size())break;
            TreeNode treeNode = map.get(s);
//            int result = getTreeNodesNum(treeNode,0,went);
            int result = dfsNoRecur(treeNode,0,went);
            sum += handleResult(result);
        }
        int absent = n-map.size();
        return sum+absent;
    }

    private static int handleResult(int result){
        double aDouble = Math.sqrt(result);
        return (int)Math.ceil(aDouble);
    }

    private static int getTreeNodesNum(TreeNode treeNode,int num,Map<String,String> went){
        if(treeNode==null || went.get(treeNode.value)!=null)return num;

        num++;
        went.put(treeNode.value,treeNode.value);
        for (TreeNode t :
                treeNode.list) {
           num = getTreeNodesNum(t,num,went);
        }
        return num;
    }


    public static int dfsNoRecur(TreeNode graphNode,int num, Map<String,String>  visited) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(graphNode);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            for (int i = 0; i < node.list.size(); i++) {
                if (visited.get(node.list.get(i).value)==null) {
                    visited.put(node.list.get(i).value,graphNode.value);;

                    stack.push(node.list.get(i));
                    num++;

                }
            }

        }
        return num;
    }

    
    static class TreeNode{
        TreeNode(String value){
            this.value = value;
        }
        String value;
        List<TreeNode> list = new ArrayList<>();

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
