package string;

public class StringCompressor {
    public String compress(String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return sb.length() < s.length() ? sb.toString() : s;
    }

    public static void main(String[] args) {
        StringCompressor obj = new StringCompressor();

        System.out.println(obj.compress("aabcccccaaa"));
        System.out.println(obj.compress("abc"));
        System.out.println(obj.compress("aaabb"));
    }
}
