package stack;

import java.util.Stack;

public class PostfixEvaluation {

    /**
     * Approach 1: Using Java Built-in Stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class BuiltInStackApproach {

        public int evaluate(String expr) {
            Stack<Integer> stack = new Stack<>();

            for (char ch : expr.toCharArray()) {

                if (Character.isDigit(ch)) {
                    stack.push(ch - '0');
                } else {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(applyOperator(a, b, ch));
                }
            }
            return stack.pop();
        }
    }

    /**
     * Approach 2: Custom Stack using Array
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class ArrayStackApproach {

        private int[] stack;
        private int top;

        public ArrayStackApproach(int capacity) {
            stack = new int[capacity];
            top = -1;
        }

        private void push(int value) {
            stack[++top] = value;
        }

        private int pop() {
            return stack[top--];
        }

        public int evaluate(String expr) {

            for (char ch : expr.toCharArray()) {

                if (Character.isDigit(ch)) {
                    push(ch - '0');
                } else {
                    int b = pop();
                    int a = pop();
                    push(applyOperator(a, b, ch));
                }
            }
            return pop();
        }
    }

    private static int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) {

        String expression = "231*+9-"; // 2 + (3*1) - 9 = -4

        System.out.println("Built-in Stack:");
        BuiltInStackApproach s1 = new BuiltInStackApproach();
        System.out.println(s1.evaluate(expression)); // -4

        System.out.println("\nArray Stack:");
        ArrayStackApproach s2 = new ArrayStackApproach(expression.length());
        System.out.println(s2.evaluate(expression)); // -4
    }
}
