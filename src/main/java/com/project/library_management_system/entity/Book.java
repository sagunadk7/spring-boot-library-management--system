package com.project.library_management_system.entity;

import jakarta.persistence.*;

import java.util.List;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private int availableCopies;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<BorrowRecord> borrowRecords;
}
