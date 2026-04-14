package array;

public class RemoveElement {

    /**
     * Approach 1: Brute Force (Shift Left)
     *
     * Idea:
     * - Iterate through the array
     * - If nums[i] == val → shift all elements to the left
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int removeElementBruteForce(int[] nums, int val) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                // shift left
                for (int j = i; j < n - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                n--;     // reduce size
                i--;     // recheck current index
            }
        }
        return n;
    }

    /**
     * Approach 2: Two Pointers (Optimal)
     *
     * Idea:
     * - Use two pointers:
     *   + i: iterate through array
     *   + k: position to place valid elements
     * - If nums[i] != val → nums[k++] = nums[i]
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeElementTwoPointers(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * Approach 3: Swap with Last (Less Writes)
     *
     * Idea:
     * - If nums[i] == val → replace it with the last element
     * - No need to preserve order
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int removeElementSwapLast(int[] nums, int val) {
        int n = nums.length;
        int i = 0;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    /**
     * Helper method to print array
     */
    private void printArray(int[] nums, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /**
     * Main method to test all approaches
     */
    public static void main(String[] args) {
        RemoveElement test = new RemoveElement();

        int[] nums1 = {3, 2, 2, 3};
        int val = 3;

        int len1 = test.removeElementBruteForce(nums1, val);
        System.out.print("Brute Force: ");
        test.printArray(nums1, len1);

        int[] nums2 = {3, 2, 2, 3};
        int len2 = test.removeElementTwoPointers(nums2, val);
        System.out.print("Two Pointers (Optimal): ");
        test.printArray(nums2, len2);

        int[] nums3 = {3, 2, 2, 3};
        int len3 = test.removeElementSwapLast(nums3, val);
        System.out.print("Swap Last: ");
        test.printArray(nums3, len3);
    }
}
