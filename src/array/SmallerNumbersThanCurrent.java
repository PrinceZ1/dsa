package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumbersThanCurrent {

    /**
     * Approach 1: Brute Force
     * For each element, count how many numbers are smaller than it
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    static class BruteForce {

        public int[] smallerNumbers(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (nums[j] < nums[i]) {
                        count++;
                    }
                }
                result[i] = count;
            }

            return result;
        }
    }

    /**
     * Approach 2: Sorting + HashMap
     * Sort the array and store first occurrence index
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    static class SortingApproach {

        public int[] smallerNumbers(int[] nums) {
            int n = nums.length;
            int[] result = new int[n];

            int[] sorted = nums.clone();
            Arrays.sort(sorted);

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                map.putIfAbsent(sorted[i], i);
            }

            for (int i = 0; i < n; i++) {
                result[i] = map.get(nums[i]);
            }

            return result;
        }
    }

    /**
     * Approach 3: Counting Sort (Optimal)
     * Since 0 <= nums[i] <= 100
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static class CountingOptimal {

        public int[] smallerNumbers(int[] nums) {
            int[] count = new int[101];
            int[] result = new int[nums.length];

            // Count frequency
            for (int num : nums) {
                count[num]++;
            }

            // Prefix sum
            for (int i = 1; i < 101; i++) {
                count[i] += count[i - 1];
            }

            // Build result
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    result[i] = 0;
                } else {
                    result[i] = count[nums[i] - 1];
                }
            }

            return result;
        }
    }

    private static void printArray(int[] nums) {
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {8, 1, 2, 2, 3};
        System.out.println("Brute Force:");
        printArray(new BruteForce().smallerNumbers(arr1));

        int[] arr2 = {8, 1, 2, 2, 3};
        System.out.println("\nSorting Approach:");
        printArray(new SortingApproach().smallerNumbers(arr2));

        int[] arr3 = {8, 1, 2, 2, 3};
        System.out.println("\nCounting Optimal:");
        printArray(new CountingOptimal().smallerNumbers(arr3));
    }
}
