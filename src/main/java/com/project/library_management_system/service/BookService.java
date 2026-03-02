package com.project.library_management_system.service;

import com.project.library_management_system.dto.BookRequestDto;
import com.project.library_management_system.dto.BookResponseDto;
import com.project.library_management_system.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<BookResponseDto> getBooksByPagination(Pageable page);
    Book addBook(BookRequestDto book);
}
