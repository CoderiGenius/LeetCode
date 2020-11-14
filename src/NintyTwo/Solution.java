package NintyTwo;

import domain.ListNode;

import java.util.List;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head==null)return head;
        ListNode before = null,nextNode;
        int position = 1;

        ListNode a = null,b = null,c = null,d = null;

        while(head!=null){
            nextNode = head.next;
            if(position==m-1)a=head;
            if(position==n+1)d=head;
            if(position>=(m) && position <= (n)){
                if(position==m)b=head;
                if(position==n)c=head;
                head.next = before;
            }
           
        before = head;
        head = nextNode;
        position++;
        }
        b.next = d;
        a.next = c;
return before;
    }

    private void  recrusive(ListNode node){

    }
}
