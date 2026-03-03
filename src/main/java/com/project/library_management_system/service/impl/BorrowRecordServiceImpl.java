package com.project.library_management_system.service.impl;

import com.project.library_management_system.dto.BorrowRecordRequestDto;
import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.entity.BorrowRecord;
import com.project.library_management_system.entity.Book;
import com.project.library_management_system.entity.User;
import com.project.library_management_system.mapper.BorrowRecordMapper;
import com.project.library_management_system.repository.BookRepository;
import com.project.library_management_system.repository.BorrowRecordRepository;
import com.project.library_management_system.repository.UserRepository;
import com.project.library_management_system.service.BorrowRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository,
                                   UserRepository userRepository,
                                   BookRepository bookRepository){
        this.borrowRecordRepository=borrowRecordRepository;
        this.userRepository=userRepository;
        this.bookRepository=bookRepository;
    }

    public BorrowRecord borrowBook(BorrowRecordRequestDto request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("User not Found"));

        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(()-> new RuntimeException("Book not Found"));

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturnDate(request.getReturnDate());

        return borrowRecordRepository.save(record);
    }

    public Page<BorrowRecordResponseDto> getPaginatedBorrowRecord(Pageable pageable) {
        return borrowRecordRepository.findAll(pageable)
                .map(BorrowRecordMapper::toResponseDto);
    }

    public List<BorrowRecord> getAllBorrowRecord(){
        return borrowRecordRepository.findAll();
    }

    public BorrowRecord returnBook(Long recordId){
        BorrowRecord record = borrowRecordRepository.findById(recordId)
                .orElseThrow(()-> new RuntimeException("Record not found"));

        record.setReturnDate(LocalDate.now());
        return borrowRecordRepository.save(record);
    }

    public List<BorrowRecord>getRecordsByUser(Long userId){
        return borrowRecordRepository.findByUserId(userId);
    }

}
