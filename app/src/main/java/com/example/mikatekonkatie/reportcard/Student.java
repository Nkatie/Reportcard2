package com.example.mikatekonkatie.reportcard;

/**
 * Created by Mikateko (Nkatie) on 2017/07/24.
 */

public class Student {
    private long id;
    private String Name;
    private String studentNo;
    private int test1, test2, average;


    public Student() {

    }

    public Student(long id, String name, String studentNo, int test1, int test2, int average) {
        this.id = id;
        Name = name;
        this.studentNo = studentNo;
        this.test1 = test1;
        this.test2 = test2;
        this.average = average;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public int getTest1() {
        return test1;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public int getTest2() {
        return test2;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }
}

