package string;

import java.util.Arrays;
import java.util.HashMap;

public class AnagramCheck {

    /**
     * Approach 1: Brute Force (Sorting)
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public boolean isAnagramBySorting(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    /**
     * Approach 2: HashMap Frequency Count
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isAnagramUsingMap(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
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
     * Approach 3: Fixed Size Array (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isAnagramUsingArray(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
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

    /**
     * Approach 4: Case-insensitive & Ignore Spaces
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isAnagramIgnoreCaseAndSpaces(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }

        s1 = s1.replaceAll("\\s+", "").toLowerCase();
        s2 = s2.replaceAll("\\s+", "").toLowerCase();

        return isAnagramUsingArray(s1, s2);
    }

    public static void main(String[] args) {
        AnagramCheck test = new AnagramCheck();

        String a = "listen";
        String b = "silent";
        String c = "Dormitory";
        String d = "Dirty room";

        System.out.println("Sorting: " + test.isAnagramBySorting(a, b));
        System.out.println("HashMap: " + test.isAnagramUsingMap(a, b));
        System.out.println("Array Count: " + test.isAnagramUsingArray(a, b));
        System.out.println("Ignore Case & Spaces: " + test.isAnagramIgnoreCaseAndSpaces(c, d));
    }
}
