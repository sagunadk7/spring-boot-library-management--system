package com.project.library_management_system.service;

import com.project.library_management_system.dto.BorrowRecordRequestDto;
import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.entity.BorrowRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BorrowRecordService {

    BorrowRecord borrowBook(BorrowRecordRequestDto request);

    List<BorrowRecord> getAllBorrowRecord();

    Page<BorrowRecordResponseDto> getPaginatedBorrowRecord(Pageable pageable);

    BorrowRecord returnBook(Long recordId);

    List<BorrowRecord>getRecordsByUser(Long userId);

}
