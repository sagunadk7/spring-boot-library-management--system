package com.project.library_management_system.controller;

import com.project.library_management_system.dto.BorrowRecordRequestDto;
import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.entity.BorrowRecord;
import com.project.library_management_system.service.BorrowRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/borrow")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;
    public BorrowRecordController(BorrowRecordService borrowRecordService){
        this.borrowRecordService=borrowRecordService;
    }
    @GetMapping
    public Page<BorrowRecordResponseDto> getPaginatedBorrowRecord(Pageable pageable){
        return borrowRecordService.getPaginatedBorrowRecord(pageable);
    }

    @GetMapping("/all")
    public List<BorrowRecord> getAllBorrowRecord(){
        return borrowRecordService.getAllBorrowRecord();
    }

    @GetMapping("/user/{userId}")
    public List<BorrowRecord> getByUser(@PathVariable Long userId){
        return borrowRecordService.getRecordsByUser(userId);
    }

    @PostMapping
    public BorrowRecord borrowBook(@RequestBody BorrowRecordRequestDto request){
        return borrowRecordService.borrowBook(request);
    }

    @PutMapping("/return/{recordId}")
    public BorrowRecord returnBook(@PathVariable Long recordId){
        return borrowRecordService.returnBook(recordId);
    }

}
