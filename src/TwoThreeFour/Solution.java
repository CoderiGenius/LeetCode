package TwoThreeFour;

import domain.ListNode;

import java.util.List;

/**
 * @author CoderiGenius
 * @version 2021/4/2 10:45 下午
 */
public class Solution {

    private static ListNode reverseList(ListNode node){
        if(node==null)return null;

        ListNode lastNode = null;
        while(node!=null){
            ListNode temp = node.next;
            node.next = lastNode;
            lastNode = node;
            node = temp;
        }
        return lastNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);

        listNode.next = listNode1;
        listNode1.next = listNode2;

       ListNode listNode3 =  reverseList(listNode);
       while (listNode3!=null){
           System.out.println(listNode3.val);
       }
    }
}
