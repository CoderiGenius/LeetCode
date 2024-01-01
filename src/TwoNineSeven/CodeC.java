package TwoNineSeven;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author CoderiGenius
 * @version 2021/4/7 3:44 下午
 */
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null)return "";
        List<String> list = new LinkedList<>();
       Queue<TreeNode> queue = new LinkedList<>();
       list.add(root.val+"");
       while(!queue.isEmpty()){
           TreeNode treeNode = queue.poll();
           if(treeNode==null){
               if(queue.isEmpty())break;
               else list.add("null");
           }else {
               list.add(treeNode.val+"");
               queue.offer(treeNode.left);
               queue.offer(treeNode.right);
           }
       }
       return list.toString().substring(1,list.toString().length()-2);
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        Queue<TreeNode> queue = new LinkedList<>();

        String[] strings = data.split(",");

        if(strings.length==0)return null;
        TreeNode treeNode = new TreeNode();
        treeNode.val = Integer.parseInt(strings[0]);
        queue.offer(treeNode);
        boolean left = false;
        for (int i = 1; i < strings.length; i++) {
            if(left){
                setNode(queue.poll(),left,strings[i],queue);
                left = false;
            }else {
                setNode(queue.peek(),left,strings[i],queue);
                left = true;
            }

        }
        return treeNode;
    }
    private void setNode(TreeNode treeNode,boolean left,String value,Queue<TreeNode> queue){
        if("null".equals(value)){
            if(left){
                treeNode.right = null;
            }else {
                treeNode.left = null;
            }
        }else{
            TreeNode treeNode1 = new TreeNode();
            treeNode1.val = Integer.parseInt(value);
            if(left){
                treeNode.right = treeNode1;
            }else {
                treeNode.left = treeNode1;
            }
            queue.offer(treeNode1);
        }

    }
}

