package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.List;

class Question7 {

    public static void main(String[] args) {
        Question7 question7 = new Question7();

        String num1 = "11";
        String num2 = "999";
        System.out.println(question7.addStrings(num1, num2));
    }

    public String addStrings(String num1, String num2) {
        int size = Math.max(num1.length(), num2.length());
        List<Character> inverseNum1 = traverse(num1, size);
        List<Character> inverseNum2 = traverse(num2, size);

        List<Integer> sum = getSum(inverseNum1, inverseNum2);
        return sumAsString(sum);
    }

    private List<Character> traverse(String str, int size) {
        List<Character> result = new ArrayList<>();

        for (int i = str.length() - 1; i >= 0; i--) {
            result.add(str.charAt(i));
        }

        for (int i = 0; i < size - result.size(); i++) {
            result.add('0');
        }
        return result;
    }

    private List<Integer> getSum(List<Character> num1, List<Character> num2) {
        List<Integer> result = new ArrayList<>();

        int carry = 0;
        for (int i = 0; i < num1.size(); i++) {
            int cur = num1.get(i) - '0' + num2.get(i) - '0' + carry;
            carry = cur / 10;
            cur = cur % 10;
            result.add(cur);
        }
        if (carry != 0) {
            result.add(carry);
        }
        return result;
    }

    private String sumAsString(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();

        for (int i = nums.size() - 1; i >= 0; i--) {
            sb.append(nums.get(i));
        }
        return sb.toString();
    }
}
