package array;

import java.util.Arrays;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums){
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i = 0; i<n; i++){
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ConcatenationOfArray test = new ConcatenationOfArray();

        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(test.getConcatenation(arr))); // 1,2,3,4,1,2,3,4
    }
}
