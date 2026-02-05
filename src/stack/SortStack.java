package stack;

import java.util.Stack;

public class SortStack {

    /**
     * Approach 1: Recursive Sort
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n) - recursion stack
     */
    static class RecursiveSort {

        public void sort(Stack<Integer> stack) {
            if (stack.isEmpty()) {
                return;
            }

            int top = stack.pop();
            sort(stack);
            insertSorted(stack, top);
        }

        private void insertSorted(Stack<Integer> stack, int value) {
            if (stack.isEmpty() || stack.peek() <= value) {
                stack.push(value);
                return;
            }

            int top = stack.pop();
            insertSorted(stack, value);
            stack.push(top);
        }
    }

    /**
     * Approach 2: Using One Extra Stack (Iterative)
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    static class IterativeSort {

        public void sort(Stack<Integer> stack) {
            Stack<Integer> temp = new Stack<>();

            while (!stack.isEmpty()) {
                int current = stack.pop();

                while (!temp.isEmpty() && temp.peek() < current) {
                    stack.push(temp.pop());
                }

                temp.push(current);
            }

            // Move back to original stack to keep ascending order
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }
    }

    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>();
        s1.push(3);
        s1.push(1);
        s1.push(4);
        s1.push(2);

        new RecursiveSort().sort(s1);
        System.out.println("Recursive Sort:");
        System.out.println(s1); // [1, 2, 3, 4]

        Stack<Integer> s2 = new Stack<>();
        s2.push(5);
        s2.push(2);
        s2.push(1);
        s2.push(4);

        new IterativeSort().sort(s2);
        System.out.println("\nIterative Sort:");
        System.out.println(s2); // [1, 2, 4, 5]
    }
}
