package edu.northeastern.hw2;

public class Question4 {

    public static void main(String[] args) {
        Question4  question4 = new Question4();

        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        question4.rotate90(nums);

        for (int[] row : nums) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void rotate90(int[][] nums) {
        transpose(nums);
        mirrorMiddleColumn(nums);
    }

    private void transpose(int[][] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                swap(nums, i, j, j, i);
            }
        }
    }

    private void mirrorMiddleColumn(int[][] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(nums, i, j, i, n - j - 1);
            }
        }
    }

    private void swap(int[][] nums, int i, int j, int n, int m) {
        int tmp = nums[i][j];
        nums[i][j] = nums[n][m];
        nums[n][m] = tmp;
    }
}
