import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// 利用LinkedHashMap中的removeEldestEntry实现
//public class LRUCache {
//    Map<Integer,Integer> map;
//    int capacity;
//
//    public LRUCache(int capacity){
//        this.capacity = capacity;
//        map = new LinkedHashMap<>(capacity,0.75f,true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry eldest){
//                return size()>capacity;
//            }
//        };
//    }
//
//    public int get(int key){
//        return map.getOrDefault(key,-1);
//    }
//
//    public void put(int key,int value){
//        map.put(key,value);
//    }
//}

public class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity);
    }

    public int get(int key){
        if(!cache.containsKey(key))//key不存在
            return -1;
        int val = cache.get(key);
        cache.remove(key);//从链表中删除
        cache.put(key,val);//添加到链表末尾
        return val;
    }

    public void put(int key,int value){
        if(cache.containsKey(key)){
            cache.remove(key);
        }
        if(capacity==cache.size()){
            Set<Integer> set = cache.keySet();
            Iterator<Integer> iterator = set.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key,value);
    }
}

