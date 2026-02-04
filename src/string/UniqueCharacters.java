package string;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueCharacters {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public boolean isUniqueBruteForce(String s) {
        for(int i = 0; i< s.length(); i++){
            for(int j = i + 1 ; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Approach 2: Using HashSet
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean isUniqueUsingSet(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 3: Sorting
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public boolean isUniqueUsingSorting(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != chars[i+1]){
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 4: Bit Manipulation (Optimal)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public boolean isUniqueUsingBitMask(String s) {
        int checker = 0;
        for(char c : s.toCharArray()){
            int bit = c - 'a';
            if((checker & (1 << bit)) > 0){
                return false;
            }
            checker |= 1 << bit;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueCharacters test = new UniqueCharacters();
        String input = "abcdefa";

        System.out.println("Brute Force: " + test.isUniqueBruteForce(input));
        System.out.println("Using HashSet: " + test.isUniqueUsingSet(input));
        System.out.println("Using Sorting: " + test.isUniqueUsingSorting(input));
        System.out.println("Using Bit Mask: " + test.isUniqueUsingBitMask(input));
    }
}
