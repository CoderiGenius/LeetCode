package TwoThree;

import domain.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0){
            return null;
        }


        return helper2(lists,0,lists.length-1);
    }

    private ListNode helper2(ListNode[] listNodes,int left,int right){
        if(left==right)return listNodes[left];

        if(left>right)return null;
        int middle = (left+right)/2;
       return helper(helper2(listNodes,left,middle),helper2(listNodes,middle+1,right));
    }

    private ListNode helper(ListNode a,ListNode b){

        if(a==null){
            return b;
        }

        ListNode listNode = new ListNode();
        ListNode newHead = listNode;

        while (a!=null || b!=null){
            if(a==null && b!=null){
                listNode.next = b;

                break;
            }else if(a!=null && b==null){
                listNode.next = a;

                break;
            }
            else if(a.val< b.val){
                listNode.next = a;
                a = a.next;
                listNode = listNode.next;
            }else {
                listNode.next = b;
                b = b.next;
                listNode = listNode.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        listNode.val = 1;
        listNode.next = listNode1;
        listNode1.val = 4;
        listNode1.next = listNode2;
        listNode2.val = 5;
        System.out.println(new Solution().mergeKLists(new ListNode[]{listNode}));
    }

}
