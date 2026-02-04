package string;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueCharacter {

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public Character firstUniqueBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return s.charAt(i);
            }
        }
        return null;
    }

    /**
     * Approach 2: HashMap + Second Pass
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public Character firstUniqueUsingMap(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    /**
     * Approach 3: Using LinkedHashMap (Order Preserved)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public Character firstUniqueUsingLinkedHashMap(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return null;
    }

    /**
     * Approach 4: Fixed Size Array (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public Character firstUniqueUsingArray(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }

        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : s.toCharArray()) {
            if (count[c] == 1) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter test = new FirstUniqueCharacter();

        String input = "swiss";

        System.out.println("Brute Force: " + test.firstUniqueBruteForce(input));
        System.out.println("HashMap: " + test.firstUniqueUsingMap(input));
        System.out.println("LinkedHashMap: " + test.firstUniqueUsingLinkedHashMap(input));
        System.out.println("Array Count: " + test.firstUniqueUsingArray(input));
    }
}
