package string;

import java.util.HashSet;

public class UniqueCharacters {
    public boolean hasAllUnique(String str) {
        HashSet<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCharacters obj = new UniqueCharacters();
        System.out.println(obj.hasAllUnique("hello"));
        System.out.println(obj.hasAllUnique("abc"));
    }
}
