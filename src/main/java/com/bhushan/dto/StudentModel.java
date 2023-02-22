package com.bhushan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {
    private int studentId;
    private String studentName;
    private int studentRollNo;
}
