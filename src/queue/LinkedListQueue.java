package queue;

/**
 * Implement Queue using Linked List
 */
public class LinkedListQueue {

    /**
     * Node definition
     */
    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Approach 1: Basic Linked List Queue
     *
     * Time Complexity:
     *  - enqueue: O(1)
     *  - dequeue: O(1)
     *
     * Space Complexity: O(n)
     */
    static class BasicQueue {
        private Node front;
        private Node rear;

        public BasicQueue() {
            front = null;
            rear = null;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);

            if (rear == null) {
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        public Integer dequeue() {
            if (front == null) {
                // Queue underflow
                return null;
            }

            int value = front.value;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            return value;
        }

        public Integer peek() {
            if (front == null) {
                return null;
            }
            return front.value;
        }

        public boolean isEmpty() {
            return front == null;
        }
    }

    /**
     * Approach 2: Linked List Queue with Size Tracking
     */
    static class SizeAwareQueue {
        private Node front;
        private Node rear;
        private int size;

        public SizeAwareQueue() {
            front = null;
            rear = null;
            size = 0;
        }

        public void enqueue(int value) {
            Node newNode = new Node(value);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }

            size++;
        }

        public Integer dequeue() {
            if (front == null) {
                return null;
            }

            int value = front.value;
            front = front.next;
            size--;

            if (front == null) {
                rear = null;
            }

            return value;
        }

        public Integer peek() {
            return front == null ? null : front.value;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {

        System.out.println("Basic Linked List Queue:");
        BasicQueue q1 = new BasicQueue();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        System.out.println(q1.dequeue()); // 10
        System.out.println(q1.peek());    // 20

        System.out.println("\nSize-Aware Linked List Queue:");
        SizeAwareQueue q2 = new SizeAwareQueue();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        System.out.println(q2.dequeue()); // 1
        System.out.println(q2.peek());    // 2
        System.out.println("Size: " + q2.size()); // 2
    }
}
