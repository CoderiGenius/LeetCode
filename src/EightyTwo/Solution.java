package EightyTwo;

import domain.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next == null){
            return head;
        }

        //Map<Integer,Integer> map = new HashMap<>();

        ListNode originHead = head;
        ListNode returnHead = new ListNode();

        // while(head!=null){
        //     if(map.get(head.val)!=null){
        //         int newInt = map.get(head.val) +1;
        //         map.put(head.val,newInt);
        //     }else{
        //         map.put(head.val,1);
        //     }
        //     head = head.next;
        // }

        //head = originHead;

//         while(head!=null && map.get(head.val)>1){
//             head = head.next;
//         }

        returnHead.next = originHead;
        head = returnHead;
        while(head!=null && head.next!=null){

            // ListNode temp = head.next;
            // System.out.println(temp.val);
            // while(temp!=null && map.get(temp.val)>1){
            //     temp = temp.next;
            // }
            // head.next = temp;
            // head = head.next;
            if(head.val == head.next.val){
                ListNode temp = head.next;
                while(temp!=null && temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }
                head.next = temp;


            }
            head = head.next;

        }

        return returnHead.next;
    }
}
