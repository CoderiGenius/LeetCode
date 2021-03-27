package OneFourSix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author CoderiGenius
 * @version 2021/3/26 5:40 下午
 */
public class NewLRUCache {

    List<Integer> list;
    HashMap<Integer,Integer> map = new HashMap<>();
    int capacity;
    int size;
    public NewLRUCache(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {

        Integer value = map.get(key);
        if(value!=null){
            renew(key,value);
            return value;
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {


        renew(key,value);
        ensureCapacity();


    }

    private void ensureCapacity(){
        if(size>capacity){
            int key = list.get(0);
            map.remove(key);
            list.remove((Integer) key);
            size--;
        }
    }

    private void renew(int key,int value){

        if(map.containsKey(key)){
            list.remove((Integer) key);
            list.add(key);
            map.put(key,value);
        }else {
            size++;
            map.put(key,value);
            list.add(key);
        }

    }

    public static void main(String[] args) {
        NewLRUCache newLRUCache  = new NewLRUCache(2);
        newLRUCache.put(2,1);
        newLRUCache.put(1,1);
        newLRUCache.put(2,3);
        newLRUCache.put(4,1);
        newLRUCache.get(1);
        newLRUCache.get(2);
    }
}
