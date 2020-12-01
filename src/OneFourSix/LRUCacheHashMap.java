package OneFourSix;

import java.util.HashMap;

class LRUCacheHashMap {
    HashMap<Integer,Node> data;
    int capacity;
    //List<Integer> list;
    int count = 0;
    Node headOut;
    Node tailIn;
    public LRUCacheHashMap(int capacity) {
        //list = new LinkedList<>();
        this.capacity = capacity;

        data = new HashMap<>(capacity);

    }

    public int get(int key) {

        // Integer integer = ;
        //Integer i = new Integer(key);
        if(!data.containsKey(key)){
            // System.out.println(list);
            return -1;
        }   else{
            Node tt = headOut;
            while(tt!=null){
                System.out.print(tt.data);
                tt = tt.next;
            }
            System.out.println("---");
//            list.remove(new Integer(key));
//            list.add(key);
            reNew();
            return  data.get(key).data;
        }

    }

    public void put(int key, int value) {
        //System.out.println(list.size());

        if(data.containsKey(key)){
            data.get(key).data = value;
            //data.put(key,value);
//            list.remove(new Integer(key));
//            list.add(key);
            remove(data.get(key),"shift");
            add(data.get(key));
            return;
        }
        if(count>=capacity){

            data.remove(tailIn.key);

            remove(tailIn,"out");
            //System.out.println(":"+list.size());
        }
        Node node = new Node();
        node.data = value;
        node.key = key;
        add(node);
        data.put(key,node);

    }
    class Node{
        Integer data;
        Node next;
        Node pre;
        Integer key;
    }
    void remove(Node node,String from){
        System.out.println("remove:"+node.data+" from:"+from);
        if(node.next==null && node.pre==null){
            tailIn = null;
            headOut = null;
            count--;
            return;
        }
        if(node.next==null){
            count--;
            node.pre.next = node.next;
            tailIn = node.pre;
            return;
        }
        if(node.pre==null){
            count--;
            node.next.pre = null;
            headOut = node.next;
            return;
        }
        count--;
        Node next = node.next;
        Node pre = node.pre;

        next.pre = pre;
        pre.next = next;
    }
    void add(Node node){
        System.out.println("add:"+node.data);

        if(headOut==null){
            headOut = node;
            tailIn = node;
            count++;
            return;
        }
        count++;
        node.next = headOut;
        headOut.pre = node;
        node.pre = null;
        headOut = node;
    }
    void reNew(){
        Node temp = tailIn;
        remove(tailIn,"renew");
        add(temp);
    }


    public static void main(String[] args) {
        LRUCacheHashMap lruCacheHashMap = new LRUCacheHashMap(2);
        System.out.println(lruCacheHashMap.get(2));
        lruCacheHashMap.put(1, 1);
        System.out.println("null");
        lruCacheHashMap.put(2, 2);
        System.out.println("null");
        System.out.println(lruCacheHashMap.get(1));
        lruCacheHashMap.put(3, 3);
        System.out.println("null");
        System.out.println(lruCacheHashMap.get(2));
        lruCacheHashMap.put(4, 4);
        System.out.println("null");
        System.out.println(lruCacheHashMap.get(1));
        System.out.println(lruCacheHashMap.get(3));
        System.out.println(lruCacheHashMap.get(4));
    }
}