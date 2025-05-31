package com.workintech.Library.console;

import com.workintech.Library.models.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Prof. Dr. Orhan Gökçay");
        Author author2 = new Author("Dr. Emine Yıldız");
        Author author3 = new Author("Prof. Dr. Mehmet Karagül");

        Book book1 = new Book(1L, author1, "Çevre Mühendisliğine Giriş", new Date(), 520.00);
        Book book2 = new Book(2L, author2, "Atık Su Arıtma Teknolojileri", new Date(), 650.75);
        Book book3 = new Book(3L, author3, "Hava Kirliliği ve Kontrolü", new Date(), 570.25);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        //ID ile kitap ara:
        Book searchBookId = library.findBookById(1L);
        if(searchBookId != null){
            searchBookId.toString();
        }

        //Kitap ismi ile kitap ara:
        Book searchedBookByName = library.findBookByName("Prof. Dr. Orhan Gökçay");
        if(searchedBookByName != null){
            searchedBookByName.toString();
        }

        // Yazar adına göre kitap ara:
        System.out.println("Author: " );
        for(Book book : library.findBooksByAuthor(author3)){
            book.toString();
        }

        //Kitap bilgilerini güncelleme:
        System.out.println("update: ");
        library.updateBook(2L, "Atık Su Arıtma Teknolojileri", author2, "in stock", "8rd Edition", 650.75 );

        // Kitap silme:
        library.removeBook(1L);

        //Kütüphaneden okuyucuya kitap verme:

        Reader reader1 = new Reader("Elif Cetin");
        library.lendBook(book1, reader1);

        System.out.println(book1);

        // MemberRecord
        MemberRecord member = new MemberRecord(1L, "Student", new Date(), 0, "Elif Cetin", "5304780487", "Sakarya");

        // Başlangıçtaki kitap sayısı
        System.out.println("No books issued: " + member.getNoBooksIssued()); // 0

        // Kitap ekleme
        member.incBookIssued();
        member.incBookIssued();
        System.out.println("No books issued after borrowing: " + member.getNoBooksIssued());

        // Kitap iade etme
        member.decBookIssued();
        System.out.println("No books issued after returning: " + member.getNoBooksIssued());

        // Üye ödeme yaptı
        member.payBill();

        // Üye bilgileri
        member.whoyouare();


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Kitap arama
        Librarian librarian = new Librarian("Ece Cetin", "ece20");

        // Kitap arama
        System.out.println("Searching for 'Atık Su Arıtma Teknolojileri':");
        Book searchedBook = librarian.searchBook(library.getBooks(), "Atık Su Arıtma Teknolojileri");
        if (searchedBook != null) {
            System.out.println("Found: " + searchedBook);
        }


    }
}