package OneFourEight;

import domain.ListNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2022/8/1 22:38
 */
class SolutionTooSlow {
    public ListNode sortList(ListNode head) {

        List<Integer> list = listToLinkedList(head);
        Collections.sort(list);
        return returnToList(list);
    }
    private ListNode returnToList(List<Integer> list){
        ListNode head = new ListNode();
        ListNode last = head;
        for (int i = 0; i < list.size(); i++) {
            ListNode newListNode = new ListNode(list.get(i));
            last.next = newListNode;
            last = newListNode;
        }
        return head.next;
    }
    private List<Integer> listToLinkedList(ListNode head){
        List<Integer> list = new LinkedList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}
