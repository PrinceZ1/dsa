package string;

import java.util.Stack;
import java.util.HashMap;

public class BalancedParentheses {

    /**
     * Approach 1: Brute Force (Repeated Removal)
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public boolean isBalancedBruteForce(String s) {
        if (s == null) {
            return false;
        }

        String prev;
        do {
            prev = s;
            s = s.replace("()", "")
                    .replace("{}", "")
                    .replace("[]", "");
        } while (!s.equals(prev));

        return s.isEmpty();
    }

    /**
     * Approach 2: Stack (Classic Interview Solution)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isBalancedUsingStack(String s) {
        if (s == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingPair(top, c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Helper method to check matching parentheses
     */
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    /**
     * Approach 3: Stack + HashMap (Clean & Scalable)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isBalancedUsingMap(String s) {
        if (s == null) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * Approach 4: Optimized Stack (Early Exit)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isBalancedOptimized(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }

        return isBalancedUsingStack(s);
    }

    public static void main(String[] args) {
        BalancedParentheses test = new BalancedParentheses();

        String s1 = "{[()]}";
        String s2 = "{[(])}";
        String s3 = "((()))";

        System.out.println("Brute Force: " + test.isBalancedBruteForce(s1));
        System.out.println("Stack: " + test.isBalancedUsingStack(s2));
        System.out.println("Map: " + test.isBalancedUsingMap(s3));
        System.out.println("Optimized: " + test.isBalancedOptimized(s1));
    }
}
