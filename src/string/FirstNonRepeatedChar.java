package string;

public class FirstNonRepeatedChar {
    public char firstNonRepeated(String s) {
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            if (count[c] == 1) {
                return c;
            }
        }
        return '_';
    }

    public static void main(String[] args) {
        FirstNonRepeatedChar obj = new FirstNonRepeatedChar();

        System.out.println(obj.firstNonRepeated("swiss"));
        System.out.println(obj.firstNonRepeated("aabbcc"));
        System.out.println(obj.firstNonRepeated("racecar"));
    }
}
