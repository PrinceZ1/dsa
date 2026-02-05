package queue;

/**
 * Implement Circular Queue using Array
 */
public class CircularQueue {

    /**
     * Approach 1: Basic Circular Queue
     *
     * Time Complexity:
     *  - enqueue: O(1)
     *  - dequeue: O(1)
     *
     * Space Complexity: O(n)
     */
    static class BasicCircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public BasicCircularQueue(int capacity) {
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

    /**
     * Approach 2: Circular Queue with Dynamic Resize
     *
     * Time Complexity:
     *  - enqueue: O(1) amortized
     *  - dequeue: O(1)
     *
     * Space Complexity: O(n)
     */
    static class DynamicCircularQueue {
        private int[] queue;
        private int front;
        private int rear;
        private int size;

        public DynamicCircularQueue() {
            queue = new int[2];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int value) {
            if (size == queue.length) {
                resize(queue.length * 2);
            }

            rear = (rear + 1) % queue.length;
            queue[rear] = value;
            size++;
        }

        public Integer dequeue() {
            if (size == 0) {
                return null;
            }

            int value = queue[front];
            front = (front + 1) % queue.length;
            size--;

            if (size > 0 && size == queue.length / 4) {
                resize(queue.length / 2);
            }

            return value;
        }

        public Integer peek() {
            return size == 0 ? null : queue[front];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void resize(int newCapacity) {
            int[] newQueue = new int[newCapacity];

            for (int i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }

            queue = newQueue;
            front = 0;
            rear = size - 1;
        }
    }

    public static void main(String[] args) {

        System.out.println("Basic Circular Queue:");
        BasicCircularQueue q1 = new BasicCircularQueue(3);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        System.out.println(q1.dequeue()); // 10
        q1.enqueue(40);
        System.out.println(q1.peek());    // 20

        System.out.println("\nDynamic Circular Queue:");
        DynamicCircularQueue q2 = new DynamicCircularQueue();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        System.out.println(q2.dequeue()); // 1
        System.out.println(q2.peek());    // 2
    }
}
