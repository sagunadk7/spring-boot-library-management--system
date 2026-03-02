package com.project.library_management_system.controller;

import com.project.library_management_system.dto.BookRequestDto;
import com.project.library_management_system.dto.BookResponseDto;
import com.project.library_management_system.service.impl.BookServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServiceImpl bookServiceImpl;
    public BookController(BookServiceImpl bookServiceImpl){
         this.bookServiceImpl=bookServiceImpl;
    }

    @GetMapping("/all")
    public List<BookResponseDto> getAllBooks(){
        return bookServiceImpl.getAllBooks();
    }

    @GetMapping
    public Page<BookResponseDto> getBooksByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "asc") String sortDir){
        Sort sort =sortDir.equalsIgnoreCase("desc")
                ? Sort.by("availableCopies").descending()
                :Sort.by("availableCopies").ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return bookServiceImpl.getBooksByPagination(pageable);
    }

    @PostMapping
    public List<BookRequestDto> addBook(@RequestBody List<BookRequestDto> book){
            for(BookRequestDto dto: book){
                bookServiceImpl.addBook(dto);
            }
        return new ArrayList<BookRequestDto>(book);
    }


}
