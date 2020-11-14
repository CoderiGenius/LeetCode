package SixtyOne;

import com.sun.jndi.ldap.LdapCtxFactory;
import domain.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution {

    public static ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next == null){
            return head;
        }

        ListNode originHead = head;
        ListNode newHead = head;
        Queue<ListNode> queue = new LinkedBlockingDeque<>();

        int length = 0;
        while(head!=null){
            head = head.next;
            length++;
        }

        head = originHead;
        if(k>length)k=k%length;
        else if (k==length)return originHead;

        ListNode temp = null;


        for (int i = 0; i <length ; i++) {
            if(head.next!=null)
            temp = head.next;
            if(i==(length-1-k)) {
                head.next = null;
            }
            if(i==(length-k)){
                head.next = originHead;
                newHead = head;
            }
            if(i>(length-k)){
                head.next = head;

            }
            head = temp;
        }


        return temp;

    }


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        for (int i = 0; i < 3; i++) {
            //do something
            System.out.println(list.get(i));
        }
        System.out.println("-----------");


        for (Integer i : list
        ) {
            System.out.println(i);
        }


    }
}
