package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithGivenSum {

    /**
     * Approach 1: Brute Force
     * --------------------------------
     * Check all possible pairs using two nested loops.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public boolean hasPairBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Approach 2: Using HashSet (Optimal for unsorted array)
     * --------------------------------
     * Store visited elements in a HashSet.
     * For each element, check if (target - current element)
     * already exists.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean hasPairUsingSet(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * Approach 3: Sorting + Two Pointers (Optimal for sorted / sortable array)
     * --------------------------------
     * Sort the array first, then use two pointers:
     * - left starts from beginning
     * - right starts from end
     *
     * Adjust pointers based on the current sum.
     *
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public boolean hasPairUsingTwoPointers(int[] arr, int target) {
        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        PairWithGivenSum test = new PairWithGivenSum();
        int[] arr = {8, 4, 1, 6, 2};
        int target = 10;

        System.out.println("Brute Force: " + test.hasPairBruteForce(arr, target));
        System.out.println("HashSet (Optimal): " + test.hasPairUsingSet(arr, target));
        System.out.println("Two Pointers: " + test.hasPairUsingTwoPointers(arr.clone(), target));
    }
}
