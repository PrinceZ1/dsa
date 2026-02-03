package array;

import java.util.Arrays;

public class RearrangeArray {

    /**
     * Approach 1: Using Extra Array (Brute Force)
     * --------------------------------
     * Create a new array and assign:
     * result[i] = arr[arr[i]]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void rearrangeUsingExtraArray(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[arr[i]];
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }
    }

    /**
     * Approach 2: In-place using Encoding Technique (Optimal)
     * --------------------------------
     * Encode both old and new values in the same index.
     *
     * Formula:
     *   arr[i] = arr[i] + (arr[arr[i]] % n) * n
     *
     * After encoding, retrieve the new value by:
     *   arr[i] = arr[i] / n
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void rearrangeInPlace(int[] arr) {
        int n = arr.length;

        // Step 1: Store both old and new values
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] + (arr[arr[i]] % n) * n;
        }

        // Step 2: Extract the new values
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / n;
        }
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        RearrangeArray test = new RearrangeArray();

        int[] arr1 = {4, 0, 2, 1, 3};
        int[] arr2 = arr1.clone();

        test.rearrangeUsingExtraArray(arr1);
        System.out.println("Using Extra Array: " + Arrays.toString(arr1));

        test.rearrangeInPlace(arr2);
        System.out.println("In-place (Optimal): " + Arrays.toString(arr2));
    }
}
