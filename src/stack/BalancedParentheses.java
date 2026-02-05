package stack;

import java.util.Stack;

public class BalancedParentheses {

    /**
     * Approach 1: Using Java Built-in Stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class BuiltInStackApproach {

        public boolean isBalanced(String expr) {
            Stack<Character> stack = new Stack<>();

            for (char ch : expr.toCharArray()) {

                // If opening bracket, push
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                }
                // If closing bracket, check match
                else if (ch == ')' || ch == '}' || ch == ']') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char top = stack.pop();
                    if (!isMatchingPair(top, ch)) {
                        return false;
                    }
                }
            }

            // Stack should be empty if balanced
            return stack.isEmpty();
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

        private boolean isEmpty() {
            return top == -1;
        }

        public boolean isBalanced(String expr) {

            for (char ch : expr.toCharArray()) {

                if (ch == '(' || ch == '{' || ch == '[') {
                    push(ch);
                }
                else if (ch == ')' || ch == '}' || ch == ']') {
                    if (isEmpty()) {
                        return false;
                    }

                    char topChar = pop();
                    if (!isMatchingPair(topChar, ch)) {
                        return false;
                    }
                }
            }

            return isEmpty();
        }
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {

        String expr1 = "{[()]}";
        String expr2 = "{[(])}";
        String expr3 = "((()))";
        String expr4 = "(((";

        BuiltInStackApproach s1 = new BuiltInStackApproach();
        System.out.println(s1.isBalanced(expr1)); // true
        System.out.println(s1.isBalanced(expr2)); // false

        ArrayStackApproach s2 = new ArrayStackApproach(20);
        System.out.println(s2.isBalanced(expr3)); // true
        System.out.println(s2.isBalanced(expr4)); // false
    }
}
