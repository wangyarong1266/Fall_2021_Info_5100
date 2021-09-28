package edu.northeastern.hw1;

class Question5 {

    public static void main(String[] args) {
        Question5 question5 = new Question5();

        System.out.println(question5.letterDigit("1a3D4f5T"));
        System.out.println(question5.letterDigit("a2bb2d4"));
    }

    public boolean letterDigit(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        return check(str);
    }

    private boolean check(String str) {
        int previous = 0;
        int next = 1;

        while (next <= str.length() - 1) {
            char prev = str.charAt(previous);
            char n = str.charAt(next);
            if (Character.isDigit(prev) && Character.isDigit(n)) {
                return false;
            } else if (Character.isLetter(prev) && Character.isLetter(n)) {
                return false;
            } else if (Character.isDigit(prev) && Character.isLetter(n)) {
                previous += 1;
                next += 1;
            } else {
                previous += 1;
                next += 1;
            }
        }
        return true;
    }
}
