package com.workintech.Library.models;

import java.util.Date;

public class Journals extends Book{
    public Journals(Long bookId, Author author, Person owner, String name, Double price, String status, String edition, Date dateOfPurchase) {
        super(bookId, author, owner, name, price, status, edition, dateOfPurchase);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}