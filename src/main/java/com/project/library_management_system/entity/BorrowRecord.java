package com.project.library_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate borrowDate;
    private LocalDate returnDate;

    @ManyToOne
    @JoinColumn(name="user_id",nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name="book_id",nullable=false)
    @JsonIgnore
    private Book book;

    public BorrowRecord(){}

    public BorrowRecord(LocalDate borrowDate, LocalDate returnDate, User user, Book book) {
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
