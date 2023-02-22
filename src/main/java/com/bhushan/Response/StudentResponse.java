package com.bhushan.Response;

import com.bhushan.entity.UserInformation;
import lombok.Data;

@Data
public class StudentResponse {
    private String status;
    private String message;
    private UserInformation userInformation;
}
