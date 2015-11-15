import java.util.LinkedHashMap;
   /**
    * HashMap makes absolutely no guarantees about the iteration order. 
    *    It can (and will) even change completely when new elements are added.
    * TreeMap will iterate according to the "natural ordering" of the keys according to their compareTo() method (or an externally supplied Comparator). 
    *  Additionally, it implements the SortedMap interface, which contains methods that depend on this sort order.
    * LinkedHashMap will iterate in the order in which the entries were put into the map
    * 
    */
public class LRUCache {
    LinkedHashMap<Integer, Integer> cache; // sorted by the insertion time
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val); //move the most visited item behind
        return val;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){ // update key value
            cache.remove(key);
        }else{
            if(size==cache.size()){ // remove the first entry
                Object least_used_key = cache.entrySet().iterator().next().getKey();
                cache.remove(least_used_key);
            }
        }
        cache.put(key, value);
    }
}
