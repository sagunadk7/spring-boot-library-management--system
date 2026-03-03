package com.project.library_management_system.dto;

import java.time.LocalDate;

public class BorrowRecordRequestDto {
    private Long userId;
    private Long bookId;
    private LocalDate returnDate;

    public BorrowRecordRequestDto(Long userId, Long bookId, LocalDate returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.returnDate = returnDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
