package string;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();

        String s1 = "babad";
        String s2 = "cbbd";
        String s3 = "a";
        String s4 = "forgeeksskeegfor";
        System.out.println("Input: " + s1 + " -> " + obj.longestPalindrome(s1));
        System.out.println("Input: " + s2 + " -> " + obj.longestPalindrome(s2));
        System.out.println("Input: " + s3 + " -> " + obj.longestPalindrome(s3));
        System.out.println("Input: " + s4 + " -> " + obj.longestPalindrome(s4));
    }
}
