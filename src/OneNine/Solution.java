package OneNine;

import domain.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head==null)return head;

        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode slow = newHead;
        ListNode fast = newHead;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        if(slow==newHead){
            if(slow.next!=null){
                newHead.next = slow.next.next;
            }else {
                newHead.next = null;
            }
        }else {
            if(slow.next!=null){
                slow.next = slow.next.next;
            }
        }



        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode.val = 1;
        listNode.next = listNode1;
        listNode1.val = 2;
//        listNode1.next = listNode2;
//        listNode2.val = 3;
//        listNode2.next = listNode3;
//        listNode3.val = 4;
//        listNode3.next = listNode4;
//        listNode4.val = 5;

        System.out.println(new Solution().removeNthFromEnd(listNode,1));
    }

}
