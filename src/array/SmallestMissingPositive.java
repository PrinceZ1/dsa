package array;

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingPositive {

    /**
     * Approach 1: Brute Force
     * --------------------------------
     * For each positive number starting from 1,
     * check if it exists in the array.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int findMissingBruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 1; i <= n + 1; i++) {
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
        return 1;
    }

    /**
     * Approach 2: Using HashSet
     * --------------------------------
     * Store all positive numbers in a HashSet.
     * Then check from 1 upwards which number is missing.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int findMissingUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (num > 0) {
                set.add(num);
            }
        }

        for (int i = 1; i <= arr.length + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Approach 3: In-place Index Marking (Optimal)
     * --------------------------------
     * Place each positive number x (1 <= x <= n)
     * at index x - 1.
     *
     * After rearrangement, the first index i
     * where arr[i] != i + 1 gives the answer.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findMissingInPlace(int[] arr) {
        int n = arr.length;

        // Step 1: Place numbers in their correct positions
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                int correctIndex = arr[i] - 1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        SmallestMissingPositive test = new SmallestMissingPositive();

        int[] arr1 = {3, 4, -1, 1};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        System.out.println("Brute Force: " + test.findMissingBruteForce(arr1));
        System.out.println("HashSet: " + test.findMissingUsingSet(arr2));
        System.out.println("In-place (Optimal): " + test.findMissingInPlace(arr3));
    }
}
