package com.generics.comparing;

public class student implements Comparable<student> {
    int rollno;
    float marks;

    public student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "student{" +
                "rollno=" + rollno +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(student o) {
        int diff=(int)(this.marks-o.marks);
        return diff;
    }
}


