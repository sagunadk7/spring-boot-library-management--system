package com.project.library_management_system.mapper;

import com.project.library_management_system.dto.BookRequestDto;
import com.project.library_management_system.dto.BookResponseDto;
import com.project.library_management_system.entity.Book;

public class BookMapper {

    public static BookResponseDto toResponseDto(Book book){
        return new BookResponseDto(
                book.getTitle(),
                book.getAuthor(),
                book.getAvailableCopies()
        );
    }

    public static Book toEntity(BookRequestDto book) {
        return new Book(
                null,
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getAvailableCopies()
        );
    }

}
