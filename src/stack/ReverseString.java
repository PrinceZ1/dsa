package stack;

import java.util.Stack;

public class ReverseString {

    /**
     * Approach 1: Using Java Built-in Stack
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class BuiltInStackApproach {

        public String reverse(String str) {
            Stack<Character> stack = new Stack<>();

            for (char ch : str.toCharArray()) {
                stack.push(ch);
            }

            StringBuilder reversed = new StringBuilder();
            while (!stack.isEmpty()) {
                reversed.append(stack.pop());
            }

            return reversed.toString();
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

        public String reverse(String str) {

            for (char ch : str.toCharArray()) {
                push(ch);
            }

            StringBuilder reversed = new StringBuilder();
            while (top != -1) {
                reversed.append(pop());
            }

            return reversed.toString();
        }
    }

    public static void main(String[] args) {

        String input = "hello world";

        System.out.println("Built-in Stack:");
        BuiltInStackApproach s1 = new BuiltInStackApproach();
        System.out.println(s1.reverse(input)); // olleh

        System.out.println("\nArray Stack:");
        ArrayStackApproach s2 = new ArrayStackApproach(input.length());
        System.out.println(s2.reverse(input)); // olleh
    }
}
