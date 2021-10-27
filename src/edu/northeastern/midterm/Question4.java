package edu.northeastern.midterm;

import java.util.HashMap;
import java.util.Map;

public class Question4 {

    public static void main(String[] args) {
        Question4 question4 = new Question4();

        String input = "aabcdefghijklmn%67*(abcbb";
        String ans = question4.longestSubstringWithoutRepeatingChars(input);
        System.out.println(ans);
    }

    public String longestSubstringWithoutRepeatingChars(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Character, Integer> counter = new HashMap<>();

        int left = 0;
        boolean hasRepeatingChars = false;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            counter.put(curChar, counter.getOrDefault(curChar, 0) + 1);
            if (counter.get(curChar) == 1) {
                continue;
            }

            String curStr = s.substring(left, right);
            ans = curStr.length() > ans.length() ? curStr : ans;
            hasRepeatingChars = true;
            while (left < right && hasRepeatingChars) {
                char leftChar = s.charAt(left);
                counter.put(leftChar, counter.get(leftChar) - 1);
                if (counter.get(leftChar) == 1) {
                    hasRepeatingChars = false;
                }
                left++;
            }
        }

        return ans;
    }
}
