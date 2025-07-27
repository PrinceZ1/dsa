package array;

public class EquilibriumIndex {
    public int equilibriumIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        EquilibriumIndex  equilibriumIndex = new EquilibriumIndex();
        int[] nums = {2,4,3,1,5};
        System.out.println(equilibriumIndex.equilibriumIndex(nums));
    }
}
