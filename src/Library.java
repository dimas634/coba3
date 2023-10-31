/**
 * @author <a href="Dimas"
 */

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;

    /**
     *
     * @param title
     * @param author
     * @return Book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     *
     * @return mengemnalikan nilai title setelah didapatkan Value
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return mengemnalikan nilai author setelah didapatkan value
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return akan mengembalikan nilai Tittle dan Author
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    /**
     *
     * @param title parameter untuk title
     * @param author parameter untuk author
     */
    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Buku berhasil ditambahkan: " + book);
    }

    /**
     *
     * @param title
     */
    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Buku ditemukan: " + book);
                return;
            }
        }
        System.out.println("Buku dengan judul '" + title + "' tidak ditemukan.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Perpustakaan kosong.");
        } else {
            System.out.println("Daftar Buku di Perpustakaan:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu Perpustakaan:");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Cari Buku");
            System.out.println("3. Tampilkan Daftar Buku");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Membuang karakter newline dari input sebelumnya
                    System.out.print("Judul Buku: ");
                    String title = scanner.nextLine();
                    System.out.print("Pengarang: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;
                case 2:
                    scanner.nextLine(); // Membuang karakter newline dari input sebelumnya
                    System.out.print("Masukkan judul buku yang dicari: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;
                case 3:
                    library.listBooks();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan perpustakaan.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 4);
    }
}
