package string;

public class PalindromeString {

    /**
     * Approach 1: Brute Force (Reverse String)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isPalindromeByReverse(String s) {
        if (s == null) {
            return false;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

    /**
     * Approach 2: Two Pointers
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isPalindromeTwoPointers(String s) {
        if (s == null) {
            return false;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeString test = new PalindromeString();

        String s1 = "racecar";
        String s2 = "A man, a plan, a canal: Panama";

        System.out.println("Reverse: " + test.isPalindromeByReverse(s1));
        System.out.println("Two Pointers: " + test.isPalindromeTwoPointers(s2));
    }
}
