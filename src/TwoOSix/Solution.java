package TwoOSix;

import domain.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {

        if(head==null){
            return head;
        }
        ListNode previousNode = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = previousNode;
            previousNode = head;
            head = next;
        }
        return previousNode;
    }
}