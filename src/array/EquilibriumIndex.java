package array;

public class EquilibriumIndex {

    /**
     * Approach 1: Brute Force
     * --------------------------------
     * For each index, calculate:
     * - sum of elements on the left
     * - sum of elements on the right
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int findEquilibriumBruteForce(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int l = 0; l < i; l++) {
                leftSum += arr[l];
            }
            for (int r = i + 1; r < n; r++) {
                rightSum += arr[r];
            }

            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 2: Using Prefix Sum
     * --------------------------------
     * Precompute prefix sums.
     *
     * Left sum at index i:
     *   prefix[i]
     * Right sum at index i:
     *   totalSum - prefix[i] - arr[i]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int findEquilibriumUsingPrefix(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int totalSum = prefix[n];

        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i];
            int rightSum = totalSum - prefix[i] - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Approach 3: Single Pass (Optimal)
     * --------------------------------
     * First calculate total sum of the array.
     * Then traverse the array while maintaining left sum.
     *
     * At index i:
     *   rightSum = totalSum - leftSum - arr[i]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findEquilibriumSinglePass(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        EquilibriumIndex test = new EquilibriumIndex();
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };

        System.out.println("Brute Force: " + test.findEquilibriumBruteForce(arr));
        System.out.println("Prefix Sum: " + test.findEquilibriumUsingPrefix(arr));
        System.out.println("Single Pass (Optimal): " + test.findEquilibriumSinglePass(arr));
    }
}
