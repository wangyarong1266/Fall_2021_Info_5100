package edu.northeastern.hw1;

import java.util.HashMap;
import java.util.Map;

class Question4 {

    public static void main(String[] args) {
        Question4 question4 = new Question4();

        String ransomNote = "aa";
        String magazine = "aba";
        System.out.println(question4.canConstruct(ransomNote, magazine));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.isEmpty()) {
            return true;
        }

        if (magazine == null || magazine.isEmpty()) {
            return false;
        }

        Map<Character, Integer> counter = recordTimes(magazine);
        return check(ransomNote, counter);
    }

    private Map<Character, Integer> recordTimes(String magazine) {
        Map<Character, Integer> counter = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }
        return counter;
    }

    private boolean check(String ransomNote, Map<Character, Integer> counter) {
        for (char c : ransomNote.toCharArray()) {
            if (!counter.containsKey(c)) {
                return false;
            }

            counter.put(c, counter.get(c) - 1);
            if (counter.get(c) < 0) {
                return false;
            }
        }

        return true;
    }
}


