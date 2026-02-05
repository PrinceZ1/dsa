package queue;

import java.util.Stack;

/**
 * Implement Queue using Two Stacks
 */
public class QueueUsingStacks {

    /**
     * Approach 1: Costly Dequeue
     * Enqueue is O(1), Dequeue is O(n)
     */
    static class CostlyDequeueQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int value) {
            stack1.push(value);
        }

        public Integer dequeue() {
            if (stack1.isEmpty()) {
                // Queue underflow
                return null;
            }

            // Move all elements to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            int value = stack2.pop();

            // Move back to stack1
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return value;
        }

        public Integer peek() {
            if (stack1.isEmpty()) {
                return null;
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            int value = stack2.peek();

            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            return value;
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    /**
     * Approach 2: Costly Enqueue
     * Enqueue is O(n), Dequeue is O(1)
     */
    static class CostlyEnqueueQueue {
        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int value) {
            // Move all elements to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            // Push new element
            stack1.push(value);

            // Move back
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        public Integer dequeue() {
            if (stack1.isEmpty()) {
                return null;
            }
            return stack1.pop();
        }

        public Integer peek() {
            if (stack1.isEmpty()) {
                return null;
            }
            return stack1.peek();
        }

        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

    /**
     * Approach 3: Amortized O(1) Queue
     *
     * Enqueue: O(1)
     * Dequeue: O(1) amortized
     */
    static class AmortizedQueue {
        private Stack<Integer> input = new Stack<>();
        private Stack<Integer> output = new Stack<>();

        public void enqueue(int value) {
            input.push(value);
        }

        public Integer dequeue() {
            if (isEmpty()) {
                return null;
            }

            if (output.isEmpty()) {
                moveInputToOutput();
            }

            return output.pop();
        }

        public Integer peek() {
            if (isEmpty()) {
                return null;
            }

            if (output.isEmpty()) {
                moveInputToOutput();
            }

            return output.peek();
        }

        public boolean isEmpty() {
            return input.isEmpty() && output.isEmpty();
        }

        private void moveInputToOutput() {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Costly Dequeue Queue:");
        CostlyDequeueQueue q1 = new CostlyDequeueQueue();
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        System.out.println(q1.dequeue()); // 10

        System.out.println("\nCostly Enqueue Queue:");
        CostlyEnqueueQueue q2 = new CostlyEnqueueQueue();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        System.out.println(q2.dequeue()); // 1

        System.out.println("\nAmortized Queue:");
        AmortizedQueue q3 = new AmortizedQueue();
        q3.enqueue(5);
        q3.enqueue(6);
        q3.enqueue(7);
        System.out.println(q3.dequeue()); // 5
        System.out.println(q3.peek());    // 6
    }
}
