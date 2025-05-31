package com.workintech.Library.models;

import java.util.Date;

public class Student extends MemberRecord{
    private String studentId;

    public Student(Long memberId, String type, Date dateOfMembership, int noBooksIssued, String name, String phoneNo, String address, String studentId) {
        super(memberId, type, dateOfMembership, noBooksIssued, name, phoneNo, address);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }


    @Override
    public void whoyouare() {
        System.out.println("Student Name: " + getName() + ", Student ID: " + studentId);
    }
}