package string;

public class StringCompression {

    /**
     * Approach 1: Brute Force using String Concatenation
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public String compressBruteForce(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String compressed = "";
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                compressed += s.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }
        }

        return compressed.length() < s.length() ? compressed : s;
    }

    /**
     * Approach 2: Using StringBuilder (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String compressUsingStringBuilder(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }

    /**
     * Approach 3: Pre-calculate Compressed Length (Optimized)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String compressOptimized(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int compressedLength = calculateCompressedLength(s);
        if (compressedLength >= s.length()) {
            return s;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        return sb.toString();
    }

    /**
     * Helper method to calculate compressed string length
     */
    private int calculateCompressedLength(String s) {
        int length = 0;
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                length += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        StringCompression test = new StringCompression();

        String input = "aabcccccaaa";

        System.out.println("Brute Force: " + test.compressBruteForce(input));
        System.out.println("StringBuilder: " + test.compressUsingStringBuilder(input));
        System.out.println("Optimized: " + test.compressOptimized(input));
    }
}
