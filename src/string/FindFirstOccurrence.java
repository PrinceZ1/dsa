package string;

public class FindFirstOccurrence {

    /**
     * Approach 1: Brute Force
     *
     * Idea:
     * - Check every possible starting index
     * - Compare characters one by one
     *
     * Time Complexity: O(n * m)
     * Space Complexity: O(1)
     */
    public int strStrBruteForce(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) return i;
        }

        return -1;
    }

    /**
     * Approach 2: KMP Algorithm
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(m)
     */
    public int strStrKMP(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) return 0;
        if (n < m) return -1;

        int[] lps = buildLPS(needle);

        int i = 0; // index for haystack
        int j = 0; // index for needle

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return i - j; // found match
            }

            // mismatch
            else if (i < n && haystack.charAt(i) != needle.charAt(j)) {
                if (j > 0) {
                    j = lps[j - 1]; // jump using LPS
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    /**
     * Build LPS array
     */
    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];

        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }

        return lps;
    }

    /**
     * Main method to test
     */
    public static void main(String[] args) {
        FindFirstOccurrence test = new FindFirstOccurrence();

        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println("Brute Force: " + test.strStrBruteForce(haystack, needle));
        System.out.println("KMP (Optimal): " + test.strStrKMP(haystack, needle));
    }
}