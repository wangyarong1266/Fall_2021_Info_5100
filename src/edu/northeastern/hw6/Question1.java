package edu.northeastern.hw6;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(888, "Jack", 3.2, new Date(97, Calendar.FEBRUARY, 6)));
        students.add(new Student(666, "Lily", 3.8, new Date(95, Calendar.JULY, 7)));
        students.add(new Student(262, "Paul", 4.0, new Date(96, Calendar.JUNE, 6)));
        students.add(new Student(128, "Alice", 3.9, new Date(93, Calendar.JANUARY, 1)));

        students.sort(new NameComparator());
        System.out.println("\nSorted by NameComparator");
        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(new GpaComparator());
        System.out.println("\nSorted by Gpa");
        for (Student student : students) {
            System.out.println(student);
        }

        students.sort(new DateOfBirthComparator());
        System.out.println("\nSorted by DateOfBirth");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student {

    Student(int id, String name, double gpa, Date dataOfBirth) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
        this.dataOfBirth = dataOfBirth;
    }

    private int id;
    private String name;
    private double gpa;
    private Date dataOfBirth;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public Date getDataOfBirth() {
        return dataOfBirth;
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, gpa: %.2f, DOB: %s", id, name, gpa, dataOfBirth);
    }
}


class NameComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.getName().compareTo(b.getName());
    }
}

class GpaComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getGpa(), a.getGpa());
    }
}


class DateOfBirthComparator implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.getDataOfBirth().compareTo(b.getDataOfBirth());
    }
}
