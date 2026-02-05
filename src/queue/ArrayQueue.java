package queue;

/**
 * Implement Queue using Array
 */
public class ArrayQueue {

    /**
     * Approach 1: Simple Array Queue
     *
     * Time Complexity:
     *  - enqueue: O(1)
     *  - dequeue: O(1)
     *
     * Space Complexity: O(n)
     */
    static class SimpleQueue {
        private int[] queue;
        private int front;
        private int rear;

        public SimpleQueue(int capacity) {
            queue = new int[capacity];
            front = 0;
            rear = -1;
        }

        public boolean enqueue(int value) {
            if (rear == queue.length - 1) {
                // Queue overflow
                return false;
            }
            queue[++rear] = value;
            return true;
        }

        public Integer dequeue() {
            if (front > rear) {
                // Queue underflow
                return null;
            }
            return queue[front++];
        }

        public Integer peek() {
            if (front > rear) {
                return null;
            }
            return queue[front];
        }

        public boolean isEmpty() {
            return front > rear;
        }
    }

    /**
     * Approach 2: Circular Queue
     *
     * Time Complexity:
     *  - enqueue: O(1)
     *  - dequeue: O(1)
     *
     * Space Complexity: O(n)
     */
    static class CircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public CircularQueue(int capacity) {
            queue = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public boolean enqueue(int value) {
            if (size == queue.length) {
                // Queue overflow
                return false;
            }

            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size++;
            return true;
        }

        public Integer dequeue() {
            if (size == 0) {
                // Queue underflow
                return null;
            }

            int value = queue[front];
            front = (front + 1) % queue.length;
            size--;
            return value;
        }

        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return queue[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == queue.length;
        }
    }

    public static void main(String[] args) {

        System.out.println("Simple Queue:");
        SimpleQueue simple = new SimpleQueue(3);
        simple.enqueue(10);
        simple.enqueue(20);
        simple.enqueue(30);
        System.out.println(simple.dequeue()); // 10
        System.out.println(simple.peek());    // 20

        System.out.println("\nCircular Queue:");
        CircularQueue circular = new CircularQueue(3);
        circular.enqueue(1);
        circular.enqueue(2);
        circular.enqueue(3);
        System.out.println(circular.dequeue()); // 1
        circular.enqueue(4); // reuse space
        System.out.println(circular.peek());    // 2
    }
}
