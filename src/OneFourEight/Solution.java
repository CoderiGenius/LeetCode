package OneFourEight;

import domain.ListNode;

/**
 * @author CoderiGenius
 * @version 2022/8/1 22:47
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if(head==null) return head;
        if(head.next == null)return head;
        if(head.next.next == null){
            // Two nodes
            if( head.val > head.next.val ){
                return swap(head, head.next);
            }else {
                return head;
            }
        }
        ListNode right = getMid(head);


        ListNode leftReturn = sortList(head);
        ListNode rightReturn = sortList(right);

        return merge(leftReturn, rightReturn);
    }
    private ListNode swap(ListNode first, ListNode second){
        first.next = second.next;
        second.next = first;
        return second;
    }
    private ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode();
        ListNode last = head;
        while (left!=null || right!=null){
            if(left==null){

                last.next = right;
                right = right.next;
            }else if(right==null){
                last.next = left;
                left = left.next;
            }else {
                if (left.val < right.val) {
                    last.next = left;
                    left = left.next;
                }else {
                    last.next = right;
                    right = right.next;
                }
            }
            last = last.next;

        }
        return head.next;
    }


    ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null && slow!=null){
            if(fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}
