package string;

import java.util.Arrays;
import java.util.HashMap;

public class StringPermutation {

    /**
     * Approach 1: Brute Force (Sorting)
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public boolean isPermutationBySorting(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    /**
     * Approach 2: Using HashMap (Frequency Count)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isPermutationUsingMap(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    /**
     * Approach 3: Using Fixed Size Array (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPermutationUsingArray(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] count = new int[256];

        for (char c : s1.toCharArray()) {
            count[c]++;
        }

        for (char c : s2.toCharArray()) {
            if (--count[c] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        StringPermutation test = new StringPermutation();

        String s1 = "listen";
        String s2 = "silent";

        System.out.println("Sorting: " + test.isPermutationBySorting(s1, s2));
        System.out.println("HashMap: " + test.isPermutationUsingMap(s1, s2));
        System.out.println("Array Count: " + test.isPermutationUsingArray(s1, s2));
    }
}
