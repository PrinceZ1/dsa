package queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * LRU Cache using Queue
 *
 * Note:
 * - This implementation is NOT O(1) for get/put
 * - Queue removal takes O(n)
 */
public class LRUCache {

    /**
     * Approach: HashMap + Queue
     *
     * Time Complexity:
     *  - get: O(n)
     *  - put: O(n)
     *
     * Space Complexity: O(capacity)
     */
    static class LRU {
        private int capacity;
        private Map<Integer, Integer> map;
        private Queue<Integer> queue;

        public LRU(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.queue = new LinkedList<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            // Update recent usage
            queue.remove(key);   // O(n)
            queue.offer(key);

            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // Update value and usage
                map.put(key, value);
                queue.remove(key); // O(n)
                queue.offer(key);
                return;
            }

            if (queue.size() == capacity) {
                // Remove least recently used key
                int lruKey = queue.poll();
                map.remove(lruKey);
            }

            map.put(key, value);
            queue.offer(key);
        }
    }

    public static void main(String[] args) {

        LRU cache = new LRU(2);

        cache.put(1, 10);
        cache.put(2, 20);
        System.out.println(cache.get(1)); // 10

        cache.put(3, 30); // evicts key 2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 40); // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 30
        System.out.println(cache.get(4)); // 40
    }
}
