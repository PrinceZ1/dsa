package array;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappeared {

    /**
     * Approach 1: Brute Force
     * For each number from 1 to n, check if it exists in array
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding result)
     */
    static class BruteForce {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;

            for (int i = 1; i <= n; i++) {
                boolean found = false;

                for (int num : nums) {
                    if (num == i) {
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    result.add(i);
                }
            }

            return result;
        }
    }

    /**
     * Approach 2: Using Extra Boolean Array
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    static class ExtraSpace {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;

            boolean[] seen = new boolean[n + 1];

            for (int num : nums) {
                seen[num] = true;
            }

            for (int i = 1; i <= n; i++) {
                if (!seen[i]) {
                    result.add(i);
                }
            }

            return result;
        }
    }

    /**
     * Approach 3: Optimal (Index Marking Trick)
     * Use input array itself to mark visited numbers
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    static class Optimal {

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            // Mark visited numbers
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;

                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }

            // Collect missing numbers
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }

    private static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Brute Force:");
        printList(new BruteForce().findDisappearedNumbers(arr1.clone()));

        int[] arr2 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("\nExtra Space:");
        printList(new ExtraSpace().findDisappearedNumbers(arr2.clone()));

        int[] arr3 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("\nOptimal (Index Marking):");
        printList(new Optimal().findDisappearedNumbers(arr3.clone()));
    }
}
