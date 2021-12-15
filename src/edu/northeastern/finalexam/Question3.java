package edu.northeastern.finalexam;

public class Question3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        System.out.println(numOfSubArraysSumToK(nums, k));
    }

    public static int numOfSubArraysSumToK(int[] nums, int k) {
        int[] prefixSum = getPrefixSum(nums);

        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i + 1; j < prefixSum.length; j++) {
                if (prefixSum[j] - prefixSum[i] == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int[] getPrefixSum(int[] nums) {
        int[] ans = new int[nums.length + 1];
        ans[0] = 0;

        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + nums[i - 1];
        }

        return ans;
    }
}
