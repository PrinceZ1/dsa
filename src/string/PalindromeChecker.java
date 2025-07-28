package string;

public class PalindromeChecker {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

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
        PalindromeChecker obj = new PalindromeChecker();
        System.out.println(obj.isPalindrome("madam"));
        System.out.println(obj.isPalindrome("racecar"));
        System.out.println(obj.isPalindrome("hello"));
    }
}
