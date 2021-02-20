package domain;

public class ListNode {
   public int val;
    public   ListNode next;
     public ListNode(int x) { val = x; }

    public ListNode() {

    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
//        return "ListNode{" +
//                "val=" + val +
//                '}';
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }



    //@Override
    public String toStringAll() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

}
