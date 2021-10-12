package edu.northeastern.hw2;

class Question8 {

    public static void main(String[] args) {
        Question8 question8 = new Question8();

        String s = "  A man, a plan, a canal: Panama";


        System.out.println(question8.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetter(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetter(s.charAt(right))) {
                right--;
            }
            if (!(Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right)))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
