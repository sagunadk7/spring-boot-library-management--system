package com.project.library_management_system.service.impl;

import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.mapper.BorrowRecordMapper;
import com.project.library_management_system.repository.BorrowRecordRepository;
import com.project.library_management_system.service.BorrowRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    private final BorrowRecordRepository borrowRecordRepository;
    public BorrowRecordServiceImpl(BorrowRecordRepository borrowRecordRepository){
        this.borrowRecordRepository=borrowRecordRepository;
    }

    public Page<BorrowRecordResponseDto> getBorrowRecord(Pageable pageable) {
        return borrowRecordRepository.findAll(pageable)
                .map(BorrowRecordMapper::toResponseDto);
    }
}
