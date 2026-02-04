package string;

public class LongestPalindrome {

    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^3)
     * Space Complexity: O(1)
     */
    public String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }

        return longest;
    }

    /**
     * Helper method to check if substring s[left..right] is a palindrome
     */
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 2: Expand Around Center (Optimal for interviews)
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public String longestPalindromeExpandCenter(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // odd length
            int len2 = expandFromCenter(s, i, i + 1);   // even length
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * Expand from the center and return palindrome length
     */
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Approach 3: Dynamic Programming
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     *
     * dp[i][j] = true if substring s[i..j] is palindrome.
     * Useful for explanation but uses extra memory.
     */
    public String longestPalindromeDP(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0;
        int maxLength = 1;

        // All single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check substrings of length >= 2
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindrome test = new LongestPalindrome();

        String input = "babad";

        System.out.println("Brute Force: " + test.longestPalindromeBruteForce(input));
        System.out.println("Expand Center: " + test.longestPalindromeExpandCenter(input));
        System.out.println("Dynamic Programming: " + test.longestPalindromeDP(input));
    }
}
