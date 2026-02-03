package array;

import java.util.Arrays;

public class RotateArray {

    /**
     * Approach 1: Rotate one by one (Brute Force)
     * --------------------------------
     * Rotate the array to the right by 1 position, k times.
     *
     * Time Complexity: O(n * k)
     * Space Complexity: O(1)
     *
     * Simple to understand but very inefficient
     * when k is large.
     */
    public void rotateByOneRepeated(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        for (int i = 0; i < k; i++) {
            int last = arr[n - 1];
            for (int j = n - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
    }

    /**
     * Approach 2: Using extra array
     * --------------------------------
     * Copy elements to a temporary array and
     * place them at the correct rotated positions.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Faster but uses extra memory.
     */
    public void rotateUsingExtraArray(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }

        System.arraycopy(temp, 0, arr, 0, n);
    }

    /**
     * Approach 3: Reversal Algorithm (Optimal)
     * --------------------------------
     * Steps:
     * 1. Reverse the whole array
     * 2. Reverse the first k elements
     * 3. Reverse the remaining n - k elements
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * This is the optimal and most commonly
     * expected solution in interviews.
     */
    public void rotateUsingReversal(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
    }

    /**
     * Helper method to reverse array elements
     * between two indices.
     */
    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        RotateArray test = new RotateArray();
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        int k = 3;

        test.rotateByOneRepeated(arr1, k);
        System.out.println("Brute Force: " + Arrays.toString(arr1));

        test.rotateUsingExtraArray(arr2, k);
        System.out.println("Extra Array: " + Arrays.toString(arr2));

        test.rotateUsingReversal(arr3, k);
        System.out.println("Reversal (Optimal): " + Arrays.toString(arr3));
    }
}
