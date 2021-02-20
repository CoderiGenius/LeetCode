package three;

import entity.TreeNode;

public class TreeDepth {

    public static void main(String[] args) {

    }

    /**
     * 求当前节点的树深
     * @param treeNode
     * @return
     */
    private int currentNodeDepth(TreeNode treeNode){

        if(treeNode==null)return 0;

        int left = currentNodeDepth(treeNode.left);
        int right = currentNodeDepth(treeNode.right);

        return Math.max(left,right)+1;
    }

    /**
     * 求当前节点的共同最小树深
     * @param treeNode
     * @return
     */
    private int currentNodeMinDepth(TreeNode treeNode){

        if(treeNode==null)return 0;

        int left = currentNodeDepth(treeNode.left);
        int right = currentNodeDepth(treeNode.right);

        return Math.min(left,right)+1;
    }
}
