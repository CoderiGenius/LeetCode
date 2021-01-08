package OneFourSix;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer,NodeLFU> map;
    int capacity;
    int length;
    NodeLFU head;
    NodeLFU tail;

    public LRUCache(int capacity) {
        this.capacity =capacity;
        this.length = 0;
        map = new HashMap<>();
    }

    public int get(int key) {

        NodeLFU nodeLFU = map.get(key);
        if(nodeLFU!=null){

            refresh(nodeLFU);
            return nodeLFU.val;
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {

        NodeLFU nodeLFU = map.get(key);
        if(nodeLFU!=null){
            nodeLFU.val = value;
            refresh(nodeLFU);
            return;
        }

        addToTail(key,value);

    }

    private void refresh(NodeLFU nodeLFU){
        removeForRefresh(nodeLFU);
        addToTailForRefresh(nodeLFU);
    }

    private void removeForRefresh(NodeLFU nodeLFU) {


        if(nodeLFU==head){
            head = head.next;
        }else if(nodeLFU==tail){
            tail = tail.pre;
        }else {
            nodeLFU.pre.next = nodeLFU.next;
            nodeLFU.next.pre = nodeLFU.pre;
        }

    }

    private void remove(NodeLFU nodeLFU) {
        map.remove(nodeLFU.key);
        length--;

        if(nodeLFU==head){
            head = head.next;
        }else if(nodeLFU==tail){
            tail = tail.pre;
        }else {
            nodeLFU.pre.next = nodeLFU.next;
            nodeLFU.next.pre = nodeLFU.pre;
        }

    }
    private void addToTail(int key,int value){
        NodeLFU nodeLFU = new NodeLFU();
        nodeLFU.key = key;
        nodeLFU.val = value;
        addToTail(nodeLFU);
    }
    private void addToTail(NodeLFU nodeLFU){

        if(tail==null){
            tail = nodeLFU;
        }else {
            tail.next = nodeLFU;
            nodeLFU.pre = tail;
            tail = nodeLFU;
        }
        if(head==null){
            head  = tail;
        }
        map.put(nodeLFU.key,nodeLFU);

        length++;
        if(length>capacity){
            remove(head);
        }
    }

    private void addToTailForRefresh(NodeLFU nodeLFU){

        if(tail==null){
            tail = nodeLFU;
        }else {
            tail.next = nodeLFU;
            nodeLFU.pre = tail;
            tail = nodeLFU;
        }
        if(head==null){
            head  = tail;
        }

    }

    class NodeLFU{
        int val;
        int key;
        NodeLFU pre;
        NodeLFU next;
    }
}