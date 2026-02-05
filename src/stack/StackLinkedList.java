package stack;

public class StackLinkedList {

    /**
     * Approach 1: Simple Linked List Stack
     *
     * Time Complexity:
     *  - push: O(1)
     *  - pop: O(1)
     *  - peek: O(1)
     *
     * Space Complexity: O(n)
     */
    static class SimpleStack {

        private Node top;

        // Node definition
        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public boolean push(int value) {
            Node node = new Node(value);
            node.next = top;
            top = node;
            return true;
        }

        public Integer pop() {
            if (top == null) {
                // Stack underflow
                return null;
            }
            int value = top.data;
            top = top.next;
            return value;
        }

        public Integer peek() {
            if (top == null) {
                return null;
            }
            return top.data;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    /**
     * Approach 2: Linked List Stack with Size Tracking
     *
     * Time Complexity:
     *  - push: O(1)
     *  - pop: O(1)
     *  - peek: O(1)
     *
     * Space Complexity: O(n)
     */
    static class SizedStack {

        private Node top;
        private int size;

        static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public void push(int value) {
            Node node = new Node(value);
            node.next = top;
            top = node;
            size++;
        }

        public Integer pop() {
            if (top == null) {
                return null;
            }
            int value = top.data;
            top = top.next;
            size--;
            return value;
        }

        public Integer peek() {
            if (top == null) {
                return null;
            }
            return top.data;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {

        System.out.println("Simple Linked List Stack:");
        SimpleStack simple = new SimpleStack();
        simple.push(10);
        simple.push(20);
        simple.push(30);
        System.out.println(simple.pop());   // 30
        System.out.println(simple.peek());  // 20

        System.out.println("\nSized Linked List Stack:");
        SizedStack sized = new SizedStack();
        sized.push(1);
        sized.push(2);
        sized.push(3);
        System.out.println(sized.pop());    // 3
        System.out.println(sized.peek());   // 2
        System.out.println("Size: " + sized.size()); // 2
    }
}
