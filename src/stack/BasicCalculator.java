package stack;

import java.util.Stack;

public class BasicCalculator {

    /**
     * Approach: Stack-based evaluation
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int calculate(String s) {
        int result = 0;
        int number = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            }
            else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            }
            else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            }
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }
            else if (c == ')') {
                result += sign * number;
                number = 0;

                result *= stack.pop(); // sign before '('
                result += stack.pop(); // result before '('
            }
        }

        result += sign * number;
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator solution = new BasicCalculator();

        String s1 = "1 + 1";
        String s2 = " 2-1 + 2 ";
        String s3 = "(1+(4+5+2)-3)+(6+8)";
        String s4 = "1 + (2 - (3 + 4))";

        System.out.println("Result 1: " + solution.calculate(s1)); // 2
        System.out.println("Result 2: " + solution.calculate(s2)); // 3
        System.out.println("Result 3: " + solution.calculate(s3)); // 23
        System.out.println("Result 4: " + solution.calculate(s4)); // -4
    }
}
