package NintyTwo;

import domain.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {

       ListNode newH = head;
      int i=1;
      ListNode before = null;
      ListNode a=null,b=null,c=null,d=null;
      while (head!=null){
          if(i==m-1)a=head;
          if(i==n+1)d=head;
          if(i>=m && i<=n){
              if(i==m)b=head;
              if(i==n)c=head;
              ListNode temp = head.next;
              head.next = before;
              before = head;
              head = temp;

              i++;
              continue;
          }
        i++;
      before = head;
          head = head.next;
      }
      if(a==null)a=c;else
      a.next = c;
        b.next = d;
return newH;
    }

    private ListNode reverse(ListNode head,ListNode end){
        ListNode pre = null;
        ListNode next ;

        while(head!=end.next){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}