package com.workintech.Library.models;

import java.util.List;
import java.util.Set;

public class Librarian extends Person {
    private String password;

    public Librarian(String name, String password) {
        super(name);
        this.password = password;
    }

    @Override
    public void whoyouare() {
        System.out.println("Librarian: " + getName());
    }

    public Book searchBook(List<Book> books, String title) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title.toLowerCase())) {
                return book;
            }
        }
        System.out.println("Book not found: " + title);
        return null;
    }

    // Okuyucu dogrulama
    public boolean verifyMember(Set<Reader> readers, Reader reader) {
        return readers.contains(reader);
    }

    // Okuyucuya kitap verme
    public void issueBook(Book book, Reader reader) {
        if (book.getOwner() == null) {
            book.changeOwner(reader);
            book.updateStatus("Lent");
            System.out.println("Book: " + book.getTitle() + " issued to " + reader.getName());
        } else {
            System.out.println("Book already lent to: " + book.getOwner().getName());
        }
    }

    // teslim tarihi gecikme cezası
    public double calculateFine(int delayedDays) {
        double delayRate = 2;
        return delayedDays * delayRate;
    }

    // fatura oluşturma
    public void createBill(Reader reader, double amount) {
        System.out.println("Reader: " + reader.getName() + ", Fine amount: " + amount);
    }

    // Kitap iade işlemi
    public void returnBook(Book book) {
        if (book.getOwner() != null) {
            System.out.println("Book: " + book.getTitle() + " returned by " + book.getOwner().getName());
            book.changeOwner(null);
            book.updateStatus("Available");
        } else {
            System.out.println("No one has borrowed the book: " + book.getTitle());
        }
    }
}