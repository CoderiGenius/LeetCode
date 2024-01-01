package ThreeThreeSeven;

import entity.TreeNode;

/**
 * @author CoderiGenius
 * @version 2021/4/9 4:54 下午
 */
public class Solution {
    public int rob(TreeNode root) {
        if(root==null)return 0;

        int chooseRootLeft = rob(root.left,true,0);
        int chooseRootRight = rob(root.right,true,0);

        int notChooseRootLeft = rob(root.left,false,0);
        int notChooseRootRight = rob(root.right,false,0);
       // System.out.println(chooseRootLeft+","+notChooseRootRight);

        int chooseRoot = chooseRootLeft+chooseRootRight+root.val;
        int notChooseRoot = notChooseRootLeft+notChooseRootRight;
       // System.out.println(chooseRoot+" "+notChooseRoot);
        return Math.max(chooseRoot,notChooseRoot);

    }

    private int rob(TreeNode root, boolean lastOneRobOrNot, int money){
        if(root==null)return money;
        int leftNot = 0;
        int rightNot = 0;
        int left = 0;
        int right = 0;
        if(lastOneRobOrNot){
//上一个节点选了，这里不能选
                left = rob(root.left,false,money);


                right = rob(root.right,false,money);

        }else {
//上一个节点没选，这个节点可选可不选
            left = rob(root.left, true, money )+root.val;
            right = rob(root.right, true, money )+root.val;

            leftNot = rob(root.left, false, money);
            rightNot = rob(root.right, false, money );
        }

        //System.out.println(left+"|"+right);
        //不选
        int not = Math.max(leftNot,rightNot);
        //选
        int yes = Math.max(left,right);
        if(!lastOneRobOrNot){
            //如果上一个节点没选，这里可以把
            not = Math.max(not,(leftNot+rightNot));
        }else{
            yes = Math.max(yes,(left+right));
        }
        return Math.max(not,yes);
    }


    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(3);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(3);
//        TreeNode treeNode4 = new TreeNode(1);
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode1.right = treeNode3;
//        treeNode2.right  = treeNode4;
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.left = treeNode1;
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        System.out.println(new Solution().rob(treeNode));
    }
}
