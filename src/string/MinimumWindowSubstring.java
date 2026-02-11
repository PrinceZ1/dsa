package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * Approach: Sliding Window
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            char c = s.charAt(right);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    required--;
                }
                map.put(c, map.get(c) - 1);
            }

            right++;

            while (required == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = s.charAt(left);

                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);

                    if (map.get(leftChar) > 0) {
                        required++;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();

        System.out.println(
                test.minWindow("ADOBECODEBANC", "ABC")
        ); // BANC
    }
}
