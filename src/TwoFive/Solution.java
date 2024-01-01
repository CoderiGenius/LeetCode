package TwoFive;

import domain.ListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2022/8/3 22:58
 */
class Solution {

    ListNode nothingList = new ListNode();
    ListNode newHeader = new ListNode();

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        if(k<=1){
            return head;
        }

        ListNode previousTail = null;
        while (head != null) {
            ListNode start = head;
            for (int i = 0; i < k-1; i++) {
                if (head == null) {

                    break;
                }
                head = head.next;
            }
            if (head == null) {
                nothingList.next = start;
                break;
            }
            ListNode next = head.next;
            head.next = null;
            ListNode newHead = reverse(start);
            if (previousTail == null) {
                newHeader.next = newHead;
            }else {
                previousTail.next = newHead;
            }
            previousTail = start;
            head = next;
        }

        if (previousTail == null) {
            newHeader.next = nothingList.next;
        }else {
            previousTail.next = nothingList.next;
        }
        return newHeader.next;
    }

    private ListNode reverse(ListNode head){
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        ListNode last = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = last;
            last = current;
            current = temp;
        }
        return last;
    }
}
