package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    /**
     * Approach 1: Sorting (Brute Force)
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public char findBySorting(String s, String t) {
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return b[i];
            }
        }
        return b[b.length - 1];
    }

    /**
     * Approach 2: HashMap Frequency Counting
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public char findByHashMap(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return c;
            }
            map.put(c, map.get(c) - 1);
        }

        return ' ';
    }

    /**
     * Approach 3: ASCII Sum
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public char findBySum(String s, String t) {
        int sum = 0;

        for (char c : t.toCharArray()) sum += c;
        for (char c : s.toCharArray()) sum -= c;

        return (char) sum;
    }

    /**
     * Approach 4: Bit Manipulation (XOR)
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public char findByXor(String s, String t) {
        int xor = 0;

        for (char c : s.toCharArray()) xor ^= c;
        for (char c : t.toCharArray()) xor ^= c;

        return (char) xor;
    }

    public static void main(String[] args) {
        FindTheDifference solver = new FindTheDifference();

        String s = "abcd";
        String t = "abcde";

        System.out.println(solver.findBySorting(s, t));
        System.out.println(solver.findByHashMap(s, t));
        System.out.println(solver.findBySum(s, t));
        System.out.println(solver.findByXor(s, t));
    }
}
