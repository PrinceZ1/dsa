package array;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    /**
     * Approach 1: Brute Force (Check each number)
     * --------------------------------
     * For each number from 1 to n, check
     * whether it exists in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int findMissingBruteForce(int[] arr, int n) {
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2: Using HashSet
     * --------------------------------
     * Store all elements in a HashSet,
     * then check which number from 1 to n is missing.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int findMissingUsingSet(int[] arr, int n) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 3: Using Sum Formula (Optimal)
     * --------------------------------
     * Expected sum of numbers from 1 to n:
     * n * (n + 1) / 2
     *
     * Subtract the actual sum of array elements
     * to get the missing number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMissingUsingSum(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    /**
     * Approach 4: Using XOR (Optimal & Safe)
     * --------------------------------
     * XOR all numbers from 1 to n
     * and XOR all elements in the array.
     *
     * Since a ^ a = 0 and a ^ 0 = a,
     * the remaining value is the missing number.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMissingUsingXor(int[] arr, int n) {
        int xorAll = 0;

        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }

        for (int num : arr) {
            xorAll ^= num;
        }

        return xorAll;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        MissingNumber test = new MissingNumber();
        int[] arr = {1, 2, 4, 5, 6};
        int n = 6;

        System.out.println("Brute Force: " + test.findMissingBruteForce(arr, n));
        System.out.println("HashSet: " + test.findMissingUsingSet(arr, n));
        System.out.println("Sum Formula: " + test.findMissingUsingSum(arr, n));
        System.out.println("XOR (Optimal): " + test.findMissingUsingXor(arr, n));
    }
}
