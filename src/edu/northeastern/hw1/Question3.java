package edu.northeastern.hw1;

import java.util.HashMap;
import java.util.Map;

class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();

        int[] nums = {2, 3, 4, 2, 2, 3, 5, 7};
        System.out.println(question3.firstUnique(nums));
    }

    public int firstUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> counter = recordTimes(nums);
        return find(nums, counter);
    }

    private Map<Integer, Integer> recordTimes(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        return counter;
    }

    private int find(int[] nums, Map<Integer, Integer> counter) {
        for (int i : nums) {
            if (counter.get(i) == 1) {
                return i;
            }
        }

        return -1;
    }
}