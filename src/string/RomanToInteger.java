package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /**
     * Approach 1: HashMap + Left to Right Traversal
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int current = map.get(s.charAt(i));

            if (i < s.length() - 1) {
                int next = map.get(s.charAt(i + 1));

                if (current < next) {
                    total -= current;
                } else {
                    total += current;
                }
            } else {
                total += current;
            }
        }

        return total;
    }

    /**
     * Approach 2: Right to Left Traversal
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int romanToIntOptimized(String s) {

        int total = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = getValue(s.charAt(i));

            if (current < prev) {
                total -= current;
            } else {
                total += current;
            }

            prev = current;
        }

        return total;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInteger test = new RomanToInteger();

        System.out.println(test.romanToInt("III"));     // 3
        System.out.println(test.romanToInt("IV"));      // 4
        System.out.println(test.romanToInt("MCMXCIV")); // 1994
    }
}
