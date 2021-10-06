package edu.northeastern.hw2;

import java.util.ArrayList;
import java.util.List;

class Question9 {

    public static void main(String[] args) {
        Question9 question9 = new Question9();

        String s = "the sky is blue";
        System.out.println(question9.reverseWordsInString(s));
    }

    public String reverseWordsInString(String s) {
        List<String> words = getEachWord(s);
        return reverseWords(words);
    }

    private List<String> getEachWord(String s) {
        List<String> ans = new ArrayList<>();
        s = " " + s + " ";
        int left = 0;
        int right = 1;

        int curWordStart = -1;

        while (right < s.length()) {
            if (s.charAt(left) == ' ' && s.charAt(right) != ' ') {
                curWordStart = right;
            } else if (s.charAt(left) != ' ' && s.charAt(right) == ' ') {
                ans.add(s.substring(curWordStart, right));
            }
            left++;
            right++;
        }

        return ans;
    }

    private String reverseWords(List<String> words) {
        StringBuilder sb = new StringBuilder();

        for (int i = words.size() - 1; i >= 0; i--) {
            if (i == words.size() - 1) {
                sb.append(words.get(i));
            } else {
                sb.append(" ").append(words.get(i));
            }
        }
        return sb.toString();
    }
}
