package OneFourSix;

import java.util.LinkedList;
import java.util.List;

public class LRUCache {
    int[] data;
    int capacity;
    List<Integer> list;
    public LRUCache(int capacity) {
        list = new LinkedList<>();
        this.capacity = capacity;
        data = new int[3001];
        for(int i=0;i<3001;i++){
            data[i] = -1;
        }
    }

    public int get(int key) {


        if(data[key]==-1){
            // System.out.println(list);
            return -1;
        }   else{
            // System.out.println(list);
            list.remove(new Integer(key));
            list.add(key);
            return  data[key];
        }

    }

    public void put(int key, int value) {
        //System.out.println(list.size());
        if(data[key]!=-1){
            data[key] = value;
            list.remove(new Integer(key));
            list.add(key);
            return;
        }
        if(list.size()>=capacity){

            data[list.get(0)] = -1;
            list.remove(0);
            //System.out.println(":"+list.size());
        }
        data[key] = value;
        list.add(key);
    }
}
