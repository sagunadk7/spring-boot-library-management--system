package com.project.library_management_system.mapper;

import com.project.library_management_system.dto.BorrowRecordResponseDto;
import com.project.library_management_system.entity.BorrowRecord;

public class BorrowRecordMapper {

    public static BorrowRecordResponseDto toResponseDto(BorrowRecord borrowRecord){
        return new BorrowRecordResponseDto(
                borrowRecord.getId(),
                borrowRecord.getBorrowDate(),
                borrowRecord.getReturnDate(),
                borrowRecord.getUser(),
                borrowRecord.getBook()
        );
    }
}
