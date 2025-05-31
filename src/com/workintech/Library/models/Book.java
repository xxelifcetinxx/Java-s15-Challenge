package com.workintech.Library.models;

import java.util.Date;

public class Book {
    private Long bookId;
    private Author author;
    private Person owner;
    private String name;
    private Double price;
    private String status;
    private String edition;
    private Date dateOfPurchase;
    private String category;

    public Book(Long bookId, Author author, String name, Date dateOfPurchase, Double price) {
        this.bookId = bookId;
        this.author = author;
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.price = price;
    }

    public Book(Long bookId, Author author, Person owner, String name, Double price, String status, String edition, Date dateOfPurchase) {
        this.bookId = bookId;
        this.author = author;
        this.owner = owner;
        this.name = name;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Person getOwner() {
        return owner;
    }

    public Long getBookId() {
        return bookId;
    }

    public void changeOwner(Reader newOwner) {
        this.owner = newOwner;
        updateStatus("Loaned ");
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Name: " + name +
                ", Author: " + author.getName() +
                ", Price: " + price +
                ", Status: " + status +
                ", Edition: " + edition +
                ", Purchased: " + dateOfPurchase +
                ", Category: " + category ;
    }
}