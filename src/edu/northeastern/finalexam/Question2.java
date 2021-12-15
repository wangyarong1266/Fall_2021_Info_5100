package edu.northeastern.finalexam;

import java.util.*;

public class Question2 {

    public static void main(String[] args) {
        String[] inputs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(inputs);
        for (List<String> group : ans) {
            for (String s : group) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());
    }
}
