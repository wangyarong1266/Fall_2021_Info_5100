package edu.northeastern.midterm;

import java.util.HashMap;
import java.util.Map;

public class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();

        int[] inputs = {1, 3, -1, 3, 4, -1};
        int ans = question3.sumOfRepeatedNumbers(inputs);
        System.out.println(ans);
    }

    public int sumOfRepeatedNumbers(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i : nums) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        int ans = 0;
        for (int i : counter.keySet()) {
            if (counter.get(i) > 1) {
                ans += i;
            }
        }

        return ans;
    }
}
