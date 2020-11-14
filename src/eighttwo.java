import domain.ListNode;

public class eighttwo {

    public ListNode deleteDuplicates(ListNode head) {


        if(head==null || head.next==null){
            return head;
        }

        ListNode foreHead = new ListNode();
        ListNode temp = head;
        ListNode fore=head;
        while(temp!=null){

            if(temp.val!=temp.next.val){
                foreHead.next = temp;
                fore = temp;
                break;
            }else{
                temp = temp.next;
            }
        }
        while(temp!=null){
            if(temp.val!=temp.next.val){
                fore.next = temp;
                fore = temp;
                temp = temp.next;
            }else{
                temp = temp.next;
            }
        }
        return foreHead.next;
    }

}
