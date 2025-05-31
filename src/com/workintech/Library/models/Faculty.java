package com.workintech.Library.models;

import java.util.Date;

public class Faculty extends MemberRecord {
    private String facultyName;
    private String facultyId;

    public Faculty(Long memberId, String type, Date dateOfMembership, int noBooksIssued,
                   String name, String phoneNo, String address, String facultyId, String facultyName) {
        super(memberId, type, dateOfMembership, noBooksIssued, name, phoneNo, address);
        this.facultyId = facultyId;
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    @Override
    public void whoyouare() {
        System.out.println("Faculty Name: " + getName() +
                ", Faculty ID: " + facultyId +
                ", Faculty Department: " + facultyName);
    }
}
