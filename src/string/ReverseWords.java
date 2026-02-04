package string;

public class ReverseWords {

    /**
     * Approach 1: Using split() (Simple)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String reverseWordsUsingSplit(String s) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }

        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    /**
     * Approach 2: Two Pass Scan (Without split)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String reverseWordsByScanning(String s) {
        if (s == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;

            int j = i;
            // Find word start
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            sb.append(s.substring(j + 1, i + 1)).append(" ");
            i = j - 1;
        }

        return sb.toString().trim();
    }

    /**
     * Approach 3: In-place (Reverse Entire String + Reverse Each Word)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String reverseWordsInPlace(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Reverse entire string
        reverse(chars, 0, n - 1);

        // Step 2: Reverse each word
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
        }

        return cleanSpaces(chars);
    }

    /**
     * Helper method to reverse characters in array
     */
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    /**
     * Remove extra spaces (leading, trailing, multiple spaces)
     */
    private String cleanSpaces(char[] arr) {
        int n = arr.length;
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < n) {
            while (i < n && arr[i] == ' ') i++;
            if (i >= n) break;

            if (sb.length() > 0) sb.append(" ");

            while (i < n && arr[i] != ' ') {
                sb.append(arr[i++]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords test = new ReverseWords();

        String input = "  the   sky  is blue  ";

        System.out.println("Using split: " + test.reverseWordsUsingSplit(input));
        System.out.println("By scanning: " + test.reverseWordsByScanning(input));
        System.out.println("In-place: " + test.reverseWordsInPlace(input));
    }
}
