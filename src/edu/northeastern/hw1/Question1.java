package edu.northeastern.hw1;

import java.util.HashMap;
import java.util.Map;

class Question1 {
    public static void main(String[] args) {
        Question1 question1 = new Question1();

        int[] nums = {2, 3, 4, 4};
        System.out.println(question1.uniqueSum(nums));
    }

    public int uniqueSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> counter = recordTimes(nums);
        return getUniqueSum(counter);
    }

    private Map<Integer, Integer> recordTimes(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }
        return counter;
    }

    private int getUniqueSum(Map<Integer, Integer> counter) {
        int sum = 0;
        for (int i : counter.keySet()) {
            if (counter.get(i) == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
