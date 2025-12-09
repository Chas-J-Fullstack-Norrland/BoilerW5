package src.main.java.se.chasacademy.databaser.v5.boilerroom.models;

import java.time.LocalDate;

public class Book {
    private int bookID;
    private String title;
    private LocalDate publishingDate;
    private String publisher;

    public Book() {}

    public Book(int bookID, String title, LocalDate publishingDate, String publisher) {
        this.bookID = bookID;
        this.title = title;
        this.publishingDate = publishingDate;
        this.publisher = publisher;
    }
    public int getBookID() {
     return bookID;
    }
    public void setBookID(int bookID) {
        this.bookID = bookID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getPublishingDate() {
        return publishingDate;
    }
    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
