package array;

public class MergeSortedArray {

    /**
     * Approach 1: Brute Force (Extra Array)
     *
     * Idea:
     * - Create a new array to store merged result
     * - Use two pointers to merge nums1 and nums2
     * - Copy back to nums1
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     */
    public void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[k++] = nums1[i++];
            } else {
                result[k++] = nums2[j++];
            }
        }

        while (i < m) {
            result[k++] = nums1[i++];
        }

        while (j < n) {
            result[k++] = nums2[j++];
        }

        // copy back to nums1
        for (int x = 0; x < m + n; x++) {
            nums1[x] = result[x];
        }
    }

    /**
     * Approach 2: Two Pointers (Optimal - From End)
     *
     * Idea:
     * - Start filling nums1 from the end
     * - Compare largest elements from nums1 and nums2
     * - Place the larger one at the back
     *
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     */
    public void mergeTwoPointers(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       // last element in nums1
        int j = n - 1;       // last element in nums2
        int k = m + n - 1;   // last position in nums1

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // only need to copy remaining nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /**
     * Helper method to print array
     */
    private void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Main method to test
     */
    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        // Brute Force
        int[] nums1Copy = nums1.clone();
        test.mergeBruteForce(nums1Copy, 3, nums2, 3);
        System.out.print("Brute Force: ");
        test.printArray(nums1Copy);

        // Optimal
        test.mergeTwoPointers(nums1, 3, nums2, 3);
        System.out.print("Two Pointers (Optimal): ");
        test.printArray(nums1);
    }
}