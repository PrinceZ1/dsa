package stack;

public class ArrayStack {

    /**
     * Approach 1: Fixed Size Array Stack
     * Time Complexity:
     *  - push: O(1)
     *  - pop: O(1)
     * Space Complexity: O(n)
     */
    static class FixedStack {
        private int[] stack;
        private int top;

        public FixedStack(int capacity) {
            stack = new int[capacity];
            top = -1;
        }

        public boolean push(int value) {
            if (top == stack.length - 1) {
                // Stack overflow
                return false;
            }
            stack[++top] = value;
            return true;
        }

        public Integer pop() {
            if (top == -1) {
                // Stack underflow
                return null;
            }
            return stack[top--];
        }

        public Integer peek() {
            if (top == -1) {
                return null;
            }
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    /**
     * Approach 2: Dynamic Array Stack (Optimized)
     * Time Complexity:
     *  - push: O(1) amortized
     *  - pop: O(1)
     * Space Complexity: O(n)
     */
    static class DynamicStack {
        private int[] stack;
        private int top;

        public DynamicStack() {
            stack = new int[2];
            top = -1;
        }

        public void push(int value) {
            if (top == stack.length - 1) {
                resize(stack.length * 2);
            }
            stack[++top] = value;
        }

        public Integer pop() {
            if (top == -1) {
                return null;
            }

            int value = stack[top--];

            // Optional shrink to save space
            if (top > 0 && top == stack.length / 4) {
                resize(stack.length / 2);
            }

            return value;
        }

        public Integer peek() {
            if (top == -1) {
                return null;
            }
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }

        private void resize(int newCapacity) {
            int[] newStack = new int[newCapacity];
            System.arraycopy(stack, 0, newStack, 0, top + 1);
            stack = newStack;
        }
    }

    public static void main(String[] args) {
        System.out.println("Fixed Stack:");
        FixedStack fixed = new FixedStack(3);
        fixed.push(10);
        fixed.push(20);
        fixed.push(30);
        System.out.println(fixed.pop());  // 30
        System.out.println(fixed.peek()); // 20

        System.out.println("\nDynamic Stack:");
        DynamicStack dynamic = new DynamicStack();
        dynamic.push(1);
        dynamic.push(2);
        dynamic.push(3);
        dynamic.push(4);
        System.out.println(dynamic.pop()); // 4
        System.out.println(dynamic.peek()); // 3
    }
}
