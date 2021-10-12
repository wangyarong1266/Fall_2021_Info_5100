package edu.northeastern.hw2;

class Question2 {

    public static void main(String[] args) {
        Question2 question2 = new Question2();

        String[] wordDict = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "makes";
        String word2 = "coding";
        System.out.println(question2.shortestDistance(wordDict, word1, word2));
    }

    private int shortestDistance(String[] wordDict, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int word1Index = -1;
        int word2Index = -1;

        for (int i = 0; i < wordDict.length; i++) {
            String curWord = wordDict[i];
            if (curWord.equals(word1)) {
                word1Index = i;
            }
            if (curWord.equals(word2)) {
                word2Index = i;
            }
            if (word1Index == -1 || word2Index == -1) {
                continue;
            }
            ans = Math.min(ans, Math.abs(word1Index - word2Index));
        }
        return ans;
    }
}

