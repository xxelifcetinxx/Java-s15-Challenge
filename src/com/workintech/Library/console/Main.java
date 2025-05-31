package com.workintech.Library.console;

import com.workintech.Library.models.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        Author author1 = new Author("Prof. Dr. Orhan Gökçay");
        Author author2 = new Author("Dr. Emine Yıldız");
        Author author3 = new Author("Prof. Dr. Mehmet Karagül");

        Book book1 = new Book(1L, author1, null, "Çevre Mühendisliğine Giriş", 520.00,
                "in stock", "3rd Edition", new Date());
        book1.setCategory("Temel Çevre");

        Book book2 = new Book(2L, author2, null, "Atık Su Arıtma Teknolojileri", 650.75,
                "in stock", "8th Edition", new Date());
        book2.setCategory("Su Yönetimi");

        Book book3 = new Book(3L, author3, null, "Hava Kirliliği ve Kontrolü", 570.25,
                "in stock", "2nd Edition", new Date());
        book3.setCategory("Hava Kalitesi");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        boolean running = true;

        while (running) {
            System.out.println("\n📚 --- Kütüphane Menüsü ---");
            System.out.println("1. Tüm kitapları listele");
            System.out.println("2. Kitap ismine göre ara");
            System.out.println("3. Kitap ID'sine göre ara");
            System.out.println("4. Kitap ekle");
            System.out.println("5. Kitap sil");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminizi yapın: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // dummy newline

            switch (choice) {
                case 1:
                    for (Book b : library.getBooks()) {
                        System.out.println(b);
                    }
                    break;

                case 2:
                    System.out.print("Kitap ismini girin: ");
                    String name = scanner.nextLine();
                    Book byName = library.findBookByName(name);
                    System.out.println(byName != null ? byName : "Kitap bulunamadı.");
                    break;

                case 3:
                    System.out.print("Kitap ID girin: ");
                    Long id = scanner.nextLong();
                    Book byId = library.findBookById(id);
                    System.out.println(byId != null ? byId : "Kitap bulunamadı.");
                    break;

                case 4:
                    System.out.print("Yeni kitap ID: ");
                    Long newId = scanner.nextLong();
                    scanner.nextLine(); // dummy newline
                    System.out.print("Yazar adı: ");
                    String authorName = scanner.nextLine();
                    Author newAuthor = new Author(authorName);
                    System.out.print("Kitap adı: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Fiyat: ");
                    double price = scanner.nextDouble();

                    Book newBook = new Book(newId, newAuthor, bookName, new Date(), price);
                    library.addBook(newBook);
                    System.out.println("Kitap eklendi.");
                    break;

                case 5:
                    System.out.print("Silinecek kitap ID: ");
                    Long removeId = scanner.nextLong();
                    library.removeBook(removeId);
                    System.out.println("Kitap silindi.");
                    break;

                case 6:
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }

        scanner.close();
    }
}