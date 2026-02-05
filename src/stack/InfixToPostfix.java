package stack;

import java.util.Stack;

public class InfixToPostfix {

    /**
     * Approach 1: Using Java Built-in Stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class BuiltInStackApproach {

        public String convert(String expr) {
            Stack<Character> stack = new Stack<>();
            StringBuilder result = new StringBuilder();

            for (char ch : expr.toCharArray()) {

                // If operand, add to result
                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                }
                // If '(', push to stack
                else if (ch == '(') {
                    stack.push(ch);
                }
                // If ')', pop until '('
                else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop(); // remove '('
                }
                // Operator
                else {
                    while (!stack.isEmpty() &&
                            precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }

            // Pop remaining operators
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return result.toString();
        }
    }

    /**
     * Approach 2: Custom Stack using Array
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class ArrayStackApproach {

        private char[] stack;
        private int top;

        public ArrayStackApproach(int capacity) {
            stack = new char[capacity];
            top = -1;
        }

        private void push(char c) {
            stack[++top] = c;
        }

        private char pop() {
            return stack[top--];
        }

        private char peek() {
            return stack[top];
        }

        private boolean isEmpty() {
            return top == -1;
        }

        public String convert(String expr) {
            StringBuilder result = new StringBuilder();

            for (char ch : expr.toCharArray()) {

                if (Character.isLetterOrDigit(ch)) {
                    result.append(ch);
                }
                else if (ch == '(') {
                    push(ch);
                }
                else if (ch == ')') {
                    while (!isEmpty() && peek() != '(') {
                        result.append(pop());
                    }
                    pop(); // remove '('
                }
                else {
                    while (!isEmpty() &&
                            precedence(ch) <= precedence(peek())) {
                        result.append(pop());
                    }
                    push(ch);
                }
            }

            while (!isEmpty()) {
                result.append(pop());
            }

            return result.toString();
        }
    }

    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {

        String infix = "a+b*(c-d)";

        System.out.println("Built-in Stack:");
        BuiltInStackApproach s1 = new BuiltInStackApproach();
        System.out.println(s1.convert(infix)); // abcd-*+

        System.out.println("\nArray Stack:");
        ArrayStackApproach s2 = new ArrayStackApproach(infix.length());
        System.out.println(s2.convert(infix)); // abcd-*+
    }
}
