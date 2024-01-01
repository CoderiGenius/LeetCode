package TwoThree;

import domain.ListNode;

import java.util.List;

/**
 * @author CoderiGenius
 * @version 2022/8/2 22:56
 */
class Solution {
    ListNode[] listNodes = new ListNode[0];
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length<1){
            return new ListNode();
        }
        if(lists.length==1){
            return lists[0];
        }
        listNodes = lists;

        ListNode newHead = new ListNode();
        ListNode lastNode = newHead;
        while (lastNode != null) {
            lastNode.next = findTheSmallest();
            lastNode = lastNode.next;
        }
        return newHead.next;

    }
    private ListNode findTheSmallest(){
        ListNode waitingNode = new ListNode(Integer.MAX_VALUE);
        ListNode temp = waitingNode;
        int position = 0;
        for (int i = 0; i < listNodes.length; i++) {
            if (listNodes[i] == null) {
                continue;
            }
            if (waitingNode.val >= listNodes[i].val) {
                waitingNode = listNodes[i];
                position = i;
            }
        }

        listNodes[position] = waitingNode.next;
        waitingNode.next = null;
        return waitingNode == temp ? null : waitingNode;
    }
}
