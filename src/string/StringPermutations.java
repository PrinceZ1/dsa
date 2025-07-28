package string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public List<String> getPermutations(String s) {
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[s.length()];
        backtrack(s, "", used, result);
        return result;
    }

    private void backtrack(String s, String current, boolean[] used, List<String> result) {
        if (current.length() == s.length()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                backtrack(s, current + s.charAt(i), used, result);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        StringPermutations obj = new StringPermutations();

        String input = "ABC";
        List<String> permutations = obj.getPermutations(input);

        System.out.println("Permutations of " + input + ":");
        for (String p : permutations) {
            System.out.println(p);
        }
    }
}
