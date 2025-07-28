package string;

public class StringPermutationCount {
    public boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[256];

        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (char c : s2.toCharArray()) {
            count[c]--;
            if (count[c] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringPermutationCount obj = new StringPermutationCount();
        System.out.println(obj.isPermutation("listen", "silent"));
        System.out.println(obj.isPermutation("triangle", "integral"));
        System.out.println(obj.isPermutation("apple", "papel"));
        System.out.println(obj.isPermutation("rat", "car"));
    }
}
