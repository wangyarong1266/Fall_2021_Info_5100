package edu.northeastern.hw2;

import java.util.*;

class Question6 {

    public static void main(String[] args) {
        Question6 question6 = new Question6();

        String s = "eggcc";
        String t = "addaa";
        System.out.println(question6.isIsomorphicStrings(s, t));
    }

    public boolean isIsomorphicStrings(String s, String t) {
        List<Integer> structureS = getStructure(s);
        List<Integer> structureT = getStructure(t);

        return compareStructure(structureS, structureT);
    }

    private List<Integer> getStructure(String str) {
        List<Integer> structure = new ArrayList<>();
        Map<Character, Integer> previousCharacters = new HashMap<>();
        int curNum = 0;

        for (char c : str.toCharArray()) {
            if (!previousCharacters.containsKey(c)) {
                previousCharacters.put(c, curNum);
                curNum++;
            }
            structure.add(previousCharacters.get(c));
        }
        return structure;
    }

    private boolean compareStructure(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }

        for (int i = 0; i < a.size(); i++) {
            if (!Objects.equals(a.get(i), b.get(i))) {
                return false;
            }
        }

        return true;
    }
}
