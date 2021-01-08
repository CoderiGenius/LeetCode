package OneFourSix;

public class test {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
        System.out.println(lruCache.get(2));
        lruCache.put(3,2);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}
