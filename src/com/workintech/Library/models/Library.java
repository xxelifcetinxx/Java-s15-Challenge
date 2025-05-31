
package com.workintech.Library.models;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Library {
    private List<Book> books;
    private Set<Reader> readers;

    public Library(){
        this.books = new ArrayList<>();
        this.readers = new HashSet<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book: " + book.getTitle());
    }

    // 2. Kitap ID ye göre kitap bulma
    public Book findBookById(Long bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        System.out.println("Book not found: " + bookId);
        return null;
    }

    // 3. Kitap ismine göre kitap bulma
    public Book findBookByName(String name) {
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(name.toLowerCase())) {
                return book;
            }
        }
        System.out.println("Book not found: " + name);
        return null;
    }

    // 4. Yazara göre kitap bulma
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    // 5. Kitap bilgilerini güncelleme
    public void updateBook(Long bookId, String name, Author author, String status, String edition, Double price) {
        Book book = findBookById(bookId);
        if (book != null) {
            book.setName(name);
            book.setAuthor(author);
            book.setStatus(status);
            book.setEdition(edition);
            book.setPrice(price);
            System.out.println("Book updated: " + book.getTitle());
        }
    }

    // 6. Kitap silme
    public void removeBook(Long bookId) {
        Book book = findBookById(bookId);
        if (book != null) {
            books.remove(book);
            System.out.println("Book removed: " + book.getTitle());
        }
    }


    public void newBook(Book book){
        books.add(book);
    }

    //Kitabı okuyucuya verme
    public void lendBook(Book book, Reader reader){
        if(books.contains(book)){
            book.changeOwner(reader);
            System.out.println("book = " + book.getTitle() + ", reader = " + reader.getName());
        }else {
            System.out.println("not found book");
        }
    }


}
