package string;

import java.util.Stack;

public class BalancedParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        BalancedParentheses obj = new BalancedParentheses();

        String s1 = "()[]{}";
        String s2 = "(]";
        String s3 = "([{}])";
        String s4 = "((())";

        System.out.println(s1 + " -> " + obj.isValid(s1));
        System.out.println(s2 + " -> " + obj.isValid(s2));
        System.out.println(s3 + " -> " + obj.isValid(s3));
        System.out.println(s4 + " -> " + obj.isValid(s4));
    }
}
