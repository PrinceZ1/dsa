package array;

import java.util.Arrays;

public class MergeSortedArrays {

    /**
     * Approach 1: Brute Force (Concatenate + Sort)
     * --------------------------------
     * Merge both arrays into one and then sort the result.
     *
     * Time Complexity: O((n + m) log (n + m))
     * Space Complexity: O(n + m)
     */
    public int[] mergeBySorting(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int index = 0;

        for (int num : a) {
            result[index++] = num;
        }
        for (int num : b) {
            result[index++] = num;
        }

        Arrays.sort(result);
        return result;
    }

    /**
     * Approach 2: Two Pointers (Optimal)
     * --------------------------------
     * Use two pointers to traverse both arrays
     * and pick the smaller element each time.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */
    public int[] mergeUsingTwoPointers(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        // Copy remaining elements from array a
        while (i < n) {
            result[k++] = a[i++];
        }

        // Copy remaining elements from array b
        while (j < m) {
            result[k++] = b[j++];
        }

        return result;
    }

    /**
     * Approach 3: In-place merge (Special Case)
     * --------------------------------
     * Assumption:
     * - First array has enough extra space at the end
     *   to hold all elements of the second array.
     *
     * Merge from the back to avoid overwriting elements.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */
    public void mergeInPlace(int[] a, int n, int[] b, int m) {
        int i = n - 1;
        int j = m - 1;
        int k = n + m - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                a[k--] = a[i--];
            } else {
                a[k--] = b[j--];
            }
        }

        // Copy remaining elements from b (if any)
        while (j >= 0) {
            a[k--] = b[j--];
        }
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        MergeSortedArrays test = new MergeSortedArrays();

        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6};

        int[] r1 = test.mergeBySorting(a, b);
        System.out.println("Concatenate + Sort: " + Arrays.toString(r1));

        int[] r2 = test.mergeUsingTwoPointers(a, b);
        System.out.println("Two Pointers (Optimal): " + Arrays.toString(r2));

        int[] aInPlace = {1, 3, 5, 7, 0, 0, 0};
        int[] bInPlace = {2, 4, 6};
        test.mergeInPlace(aInPlace, 4, bInPlace, 3);
        System.out.println("In-place merge: " + Arrays.toString(aInPlace));
    }
}
