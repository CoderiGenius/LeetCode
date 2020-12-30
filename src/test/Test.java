package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Test {

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(3);
//        ListNode listNode1 = new ListNode(2,listNode);
//        ListNode listNode2 = new ListNode(1,listNode1);
//        ListNode temp = listNode2.next;
//        System.out.println(temp.val);
//        listNode2.next = listNode;
//        System.out.println(temp.val);

       Integer i = 0;

        test(i);
       // Thread.interrupted()
        System.out
                .println(i);
    }

    private static void test(Integer i){
        i = i + 1;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if(head==null){
            return head;
        }
        System.out.println(head);
        int position = 1;
        List<ListNode> arrays = new ArrayList<>();
        while(head!=null){
            if(position>=(m) && position <= (n))
            {
                arrays.add(n-(position-m),head);
                head = head.next;
            }
            else{
                arrays.add(position,head);

            }
        }
        ListNode listNode = new ListNode();

        listNode = arrays.get(1);

        for(int i=1;i<arrays.size();i++){

            listNode.next = arrays.get(i+1);
            listNode = listNode.next;

        }

        return listNode;
    }
}
