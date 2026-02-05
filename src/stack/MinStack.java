package stack;

import java.util.Stack;

public class MinStack {

    /**
     * Approach 1: Two Stacks
     *
     * Time Complexity:
     *  - push: O(1)
     *  - pop: O(1)
     *  - getMin: O(1)
     *
     * Space Complexity: O(n)
     */
    static class TwoStackMin {

        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public void push(int value) {
            stack.push(value);

            if (minStack.isEmpty() || value <= minStack.peek()) {
                minStack.push(value);
            }
        }

        public Integer pop() {
            if (stack.isEmpty()) {
                return null;
            }

            int value = stack.pop();

            if (value == minStack.peek()) {
                minStack.pop();
            }

            return value;
        }

        public Integer top() {
            return stack.isEmpty() ? null : stack.peek();
        }

        public Integer getMin() {
            return minStack.isEmpty() ? null : minStack.peek();
        }
    }

    /**
     * Approach 2: Single Stack with Encoded Values
     *
     * Time Complexity:
     *  - push: O(1)
     *  - pop: O(1)
     *  - getMin: O(1)
     *
     * Space Complexity: O(1) extra
     */
    static class EncodedMinStack {

        private Stack<Long> stack = new Stack<>();
        private long min;

        public void push(int value) {
            if (stack.isEmpty()) {
                stack.push((long) value);
                min = value;
            } else if (value < min) {
                // Encode value
                stack.push(2L * value - min);
                min = value;
            } else {
                stack.push((long) value);
            }
        }

        public Integer pop() {
            if (stack.isEmpty()) {
                return null;
            }

            long top = stack.pop();

            if (top < min) {
                // Decode previous min
                int originalMin = (int) min;
                min = 2 * min - top;
                return originalMin;
            }

            return (int) top;
        }

        public Integer top() {
            if (stack.isEmpty()) {
                return null;
            }

            long top = stack.peek();
            return top < min ? (int) min : (int) top;
        }

        public Integer getMin() {
            return stack.isEmpty() ? null : (int) min;
        }
    }

    public static void main(String[] args) {

        System.out.println("Two Stack Min Stack:");
        TwoStackMin s1 = new TwoStackMin();
        s1.push(5);
        s1.push(3);
        s1.push(7);
        s1.push(2);
        System.out.println(s1.getMin()); // 2
        s1.pop();
        System.out.println(s1.getMin()); // 3

        System.out.println("\nEncoded Min Stack:");
        EncodedMinStack s2 = new EncodedMinStack();
        s2.push(5);
        s2.push(3);
        s2.push(7);
        s2.push(2);
        System.out.println(s2.getMin()); // 2
        s2.pop();
        System.out.println(s2.getMin()); // 3
    }
}
