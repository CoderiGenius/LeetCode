package OneFourTwo;

import domain.ListNode;

public class Solution {

    public ListNode detectCycle(ListNode head) {

        ListNode slow  = head;
        ListNode quick = head;
        while(quick!=null && quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;
            if(slow==quick){
                break;
            }
        }
        if(quick==null || quick.next==null){
            return null;
        }
        quick = head;

        while (quick!=slow){
            slow = slow.next;
            quick = quick.next;
        }

        return quick;



    }

}
