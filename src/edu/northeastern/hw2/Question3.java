package edu.northeastern.hw2;

class Question3 {

    public static void main(String[] args) {
        Question3 question3 = new Question3();

        int[] num = {0, 1, 0, 3, 0, 5, 12};
        question3.moveZeros(num);

        for (int i : num) {
            System.out.print(i + " ");
        }
    }

    public void moveZeros(int[] num) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] != 0) {
                continue;
            }

            int next = i;
            while (next < num.length && num[next] == 0) {
                next++;
            }
            if (next == num.length) {
                return;
            }
            int medium = num[i];
            num[i] = num[next];
            num[next] = medium;
        }
    }
}
