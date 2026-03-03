package com.project.library_management_system.repository;

import com.project.library_management_system.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findByUserId(Long userId);

    List<BorrowRecord> findByBookId(Long bookId);
}
