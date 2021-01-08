package test.TestThread;

public class main {

    public static void main(String[] args) throws InterruptedException {
       NodeTest nodeTest = new NodeTest();
       NodeTest nodeTest1 = new NodeTest();
       NodeTest nodeTest2 = new NodeTest();
       nodeTest.next = nodeTest1;
       nodeTest.val = 1;
       nodeTest1.pre = nodeTest;
       nodeTest1.val = 2;
       nodeTest1.next = nodeTest2;
       nodeTest2.pre = nodeTest1;
       nodeTest2.val = 3;
       nodeTest2.next = null;


       NodeTest temp = nodeTest;
       while(temp!=null){
           System.out.println(temp.val);
           temp = temp.next;
       }
       System.out.println("-------");
       nodeTest1.pre.next = nodeTest1.next;
       nodeTest1.next.pre = nodeTest1.pre;
        temp = nodeTest;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;

        }
    }

    static class NodeTest{
        NodeTest pre;
        NodeTest next;
        int val;
    }
}
