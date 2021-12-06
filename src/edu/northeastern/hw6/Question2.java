package edu.northeastern.hw6;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Question2 {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = format.parse(date);
        Date now = format.parse("12/05/2021");
        long yearDiff = TimeUnit.MILLISECONDS.toDays(now.getTime() - dob.getTime()) / 365;

        try {
            if (yearDiff < 16) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.printf("The age of the applicant is %d which is too early to apply for a driving license%n", yearDiff);
        }
    }
}
