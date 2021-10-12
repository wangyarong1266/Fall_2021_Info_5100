package edu.northeastern.hw2;

class Question10 {

    public static void main(String[] args) {
        Question10 question10 = new Question10();

        char[] array = {'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = question10.compressString(array);

        for (int i = 0; i < len; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int compressString(char[] chars) {
        String compressedString = compress(chars);
        System.out.println(compressedString);
        writeBack(compressedString, chars);
        return compressedString.length();
    }

    private String compress(char[] chars) {
        int left = 0;
        int right = 0;

        StringBuilder sb = new StringBuilder();

        while (left < chars.length) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            sb.append(chars[left]);
            if (right - left > 1) {
                sb.append(right - left);
            }
            left = right;
        }
        return sb.toString();
    }

    private void writeBack(String s, char[] array) {
        for (int i = 0; i < s.length(); i++) {
            array[i] = s.charAt(i);
        }
    }
}
