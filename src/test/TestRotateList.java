package test;

/**
 * @author CoderiGenius
 * @version 2022/7/30 22:47
 */
public class TestRotateList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2, listNode);
        ListNode listNode2 = new ListNode(1, listNode1);


        while (listNode2!=null){
            System.out.println(listNode2.val);
            listNode2 = listNode2.next;
        }

//        while (result!=null){
//            System.out.println(result.val);
//            result = result.next;
//        }
    }

    private static ListNode rotateList(ListNode listNode) {

        ListNode temp;
        ListNode last = null;
        while(listNode!=null){
            temp = listNode.next;
            listNode.next = last;
            last = listNode;
            listNode = temp;
        }
        return last;
    }

}
