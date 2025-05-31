package com.workintech.Library.models;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {
    private List<Book> books;

    public Author(String name) {
        super(name);
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void whoyouare() {
        System.out.println("Author Name: " + getName());
    }

    @Override
    public String toString() {
        return "Author Name: " + getName() + ", Books: " + books.size();
    }
}