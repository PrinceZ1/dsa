package array;

import java.util.Arrays;

public class DutchNationalFlag {

    /**
     * Approach 1: Sorting (Brute Force)
     * --------------------------------
     * Simply sort the array.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sort internals)
     */
    public void sortUsingLibrary(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * Approach 2: Counting (Two Pass)
     * --------------------------------
     * Count number of 0s, 1s, and 2s.
     * Then overwrite the array accordingly.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void sortByCounting(int[] arr) {
        int count0 = 0, count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        int index = 0;
        while (count0-- > 0) arr[index++] = 0;
        while (count1-- > 0) arr[index++] = 1;
        while (count2-- > 0) arr[index++] = 2;
    }

    /**
     * Approach 3: Dutch National Flag Algorithm (Optimal)
     * --------------------------------
     * Use three pointers:
     * - low: boundary for 0s
     * - mid: current element
     * - high: boundary for 2s
     *
     * Rules:
     * - If arr[mid] == 0: swap with low, move both
     * - If arr[mid] == 1: move mid
     * - If arr[mid] == 2: swap with high, move high
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void sortDNF(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }

    /**
     * Helper method to swap elements
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        DutchNationalFlag test = new DutchNationalFlag();

        int[] arr1 = {2, 0, 2, 1, 1, 0};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        test.sortUsingLibrary(arr1);
        System.out.println("Sorting: " + Arrays.toString(arr1));

        test.sortByCounting(arr2);
        System.out.println("Counting: " + Arrays.toString(arr2));

        test.sortDNF(arr3);
        System.out.println("DNF (Optimal): " + Arrays.toString(arr3));
    }
}
