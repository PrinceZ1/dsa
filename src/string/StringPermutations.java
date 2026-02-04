package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {

    /**
     * Approach 1: Backtracking with Swapping (Classic)
     * Time Complexity: O(n!)
     * Space Complexity: O(n) (recursion stack)
     */
    public List<String> permuteBySwapping(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        char[] chars = s.toCharArray();
        backtrackSwap(chars, 0, result);
        return result;
    }

    private void backtrackSwap(char[] chars, int index, List<String> result) {
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            backtrackSwap(chars, index + 1, result);
            swap(chars, index, i); // backtrack
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * Approach 2: Backtracking with Used Array
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     */
    public List<String> permuteUsingUsedArray(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        boolean[] used = new boolean[s.length()];
        backtrackUsed(s, new StringBuilder(), used, result);
        return result;
    }

    private void backtrackUsed(String s, StringBuilder current,
                               boolean[] used, List<String> result) {
        if (current.length() == s.length()) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            current.append(s.charAt(i));

            backtrackUsed(s, current, used, result);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    /**
     * Approach 3: Handle Duplicate Characters
     * Time Complexity: O(n!)
     * Space Complexity: O(n)
     */
    public List<String> permuteUnique(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        backtrackUnique(chars, new boolean[chars.length],
                new StringBuilder(), result);
        return result;
    }

    private void backtrackUnique(char[] chars, boolean[] used,
                                 StringBuilder current, List<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            current.append(chars[i]);

            backtrackUnique(chars, used, current, result);

            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        StringPermutations test = new StringPermutations();

        String input = "abc";
        String inputWithDup = "aab";

        System.out.println("Swap approach: " + test.permuteBySwapping(input));
        System.out.println("Used array: " + test.permuteUsingUsedArray(input));
        System.out.println("Unique permutations: " + test.permuteUnique(inputWithDup));
    }
}
