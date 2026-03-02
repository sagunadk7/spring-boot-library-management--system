package com.project.library_management_system.service.impl;

import com.project.library_management_system.dto.BookRequestDto;
import com.project.library_management_system.dto.BookResponseDto;
import com.project.library_management_system.entity.Book;
import com.project.library_management_system.mapper.BookMapper;
import com.project.library_management_system.repository.BookRepository;
import com.project.library_management_system.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public Page<BookResponseDto> getBooksByPagination(Pageable pageable){
        return bookRepository.findAll(pageable)
                .map(BookMapper::toResponseDto);
    }

    public List<BookResponseDto> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toResponseDto)
                .toList();
    }

    public Book addBook(BookRequestDto book){
        Book book1 = BookMapper.toEntity(book);
        return bookRepository.save(book1);
    }
}
