package com.project.library_management_system.service;

import com.project.library_management_system.dto.BorrowRecordResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BorrowRecordService {
    Page<BorrowRecordResponseDto> getBorrowRecord(Pageable pageable);

}
