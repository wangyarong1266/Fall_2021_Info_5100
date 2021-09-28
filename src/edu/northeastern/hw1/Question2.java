package edu.northeastern.hw1;

import java.util.ArrayList;
import java.util.List;

class Question2 {

    public static void main(String[] args) {
        Question2 question2 = new Question2();

        int[] nums = {-4, -1, 0, 3, 10};
        List<Integer> results = question2.sortSquare(nums);
        results.forEach(i -> System.out.print(i + " "));
    }

    public List<Integer> sortSquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int index = findFirstNonNegative(nums);
        return mergesort(nums, index);
    }

    private int findFirstNonNegative(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }

        return nums.length;
    }

    private List<Integer> mergesort(int[] nums, int index) {
        List<Integer> sorted = new ArrayList<>();
        int left = index - 1;
        int right = index;
        while (left >= 0 && right < nums.length) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if (leftSquare <= rightSquare) {
                sorted.add(leftSquare);
                left--;
            } else {
                sorted.add(rightSquare);
                right++;
            }
        }

        while (left >= 0) {
            sorted.add(nums[left] * nums[left]);
            left--;
        }

        while (right < nums.length) {
            sorted.add(nums[right] * nums[right]);
            right++;
        }
        return sorted;
    }
}
