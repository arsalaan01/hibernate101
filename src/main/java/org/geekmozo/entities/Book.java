package org.geekmozo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "T_BOOK")
public class Book {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bookId;

    @Column(name = "BOOKNAME")
    String bookName;

    @Column(name = "PUBLISHER")
    String publisher;

    @Column(name = "PRICE")
    int price;

    @Column(name = "CATEGORY")
    String category;

    @Embedded
    Library library;

    public Book() {
    }

    public Book(String bookName, String publisher, int price, String category, Library library) {
        this.bookName = bookName;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.library = library;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}
