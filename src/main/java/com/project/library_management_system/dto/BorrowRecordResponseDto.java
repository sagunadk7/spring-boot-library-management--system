package com.project.library_management_system.dto;

import com.project.library_management_system.entity.Book;
import com.project.library_management_system.entity.User;

import java.time.LocalDate;

public class BorrowRecordResponseDto {

    private Long id;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private User user;
    private Book book;

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

    public BorrowRecordResponseDto(Long id, LocalDate borrowDate, LocalDate returnDate, User user, Book book) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }
}

