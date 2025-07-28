package string;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");
        StringBuilder sb = new StringBuilder(s);

        reverse(sb, 0, sb.length() - 1);

        int start = 0;
        for (int end = 0; end <= sb.length(); end++) {
            if (end == sb.length() || sb.charAt(end) == ' ') {
                reverse(sb, start, end - 1);
                start = end + 1;
            }
        }

        return sb.toString();
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseWords obj = new ReverseWords();

        System.out.println(obj.reverseWords("Hello World"));
        System.out.println(obj.reverseWords("  the sky is  blue  "));
    }
}
