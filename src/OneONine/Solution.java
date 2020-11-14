package OneONine;

import domain.ListNode;

import javax.swing.tree.TreeNode;


class Solution {
//    public TreeNode sortedListToBST(ListNode head) {
//
//        if(head==null){
//            return new TreeNode();
//        }
//        if(head.next == null){
//            return new TreeNode(head.val);
//        }
//
//        ListNode middle;
//        ListNode fast = head;
//        ListNode slow = head;
//        ListNode slow_1 = head;
//
//        while(true){
//            if(fast.next.next!=null) {
//                fast = fast.next.next;
//            }else {
//                break;
//            }
//            slow_1 = slow;
//            slow = slow.next;
//        }
//        middle = slow;
//        while (fast.next!=null){
//            fast = fast.next;
//        }
//
//        TreeNode treeNode = helper(head,slow_1);
//        TreeNode treeNode2 = helper(slow.next,fast);
//        TreeNode treeNode1 = new TreeNode(middle.val,treeNode,treeNode2);
//        return treeNode1;
//    }
//
//    private TreeNode helper(ListNode start,ListNode end){
//
//        if(start==end){
//            return new TreeNode(start.val);
//        }
//        if(start.next.next==end){
//            TreeNode treeNode = new TreeNode(start.val);
//            TreeNode treeNode2 = new TreeNode(end.val);
//            TreeNode treeNode1 = new TreeNode(start.next.val,treeNode,treeNode2);
//            return treeNode1;
//        }
//
//        ListNode middle;
//        ListNode fast = start;
//        ListNode slow = start;
//        ListNode slow_1 = start;
//
//        while(true){
//            if(fast.next.next==end) {
//                fast = fast.next.next;
//                slow_1 = slow;
//                slow = slow.next;
//                break;
//            }else {
//                fast = fast.next.next;
//                slow_1 = slow;
//                slow = slow.next;
//            }
//
//        }
//        middle = slow;
//
//        TreeNode treeNode = helper(start,slow_1);
//        TreeNode treeNode2 = helper(slow.next,end);
//        TreeNode treeNode1 = new TreeNode(middle.val,treeNode,treeNode2);
//        return treeNode1;
//
//    }
}
