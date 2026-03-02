package com.project.library_management_system.controller;

import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.service.BorrowRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/borrowrecords")
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;
    public BorrowRecordController(BorrowRecordService borrowRecordService){
        this.borrowRecordService=borrowRecordService;
    }
    @GetMapping
    public Page<BorrowRecordResponseDto> getBorrowRecord(Pageable pageable){
        return borrowRecordService.getBorrowRecord(pageable);
    }

}
