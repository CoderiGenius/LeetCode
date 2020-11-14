package TwoOSix;

import domain.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)return head;
        ListNode before = null,nextNode;
        int position = 1;
        while(head!=null){
            //先保存当前节点的next指针，然后将当前节点的next指向*当前节点的前一个节点*
            //同时下一次循环，循环刚刚保存的next指针
            nextNode = head.next;

            head.next = before;

            before = head;
            head = nextNode;
            position++;
        }
        return before;
    }
}