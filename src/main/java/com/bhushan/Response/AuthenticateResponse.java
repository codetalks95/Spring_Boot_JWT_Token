package com.bhushan.Response;

import lombok.Data;

@Data
public class AuthenticateResponse {
    private String statusCode;
    private String message;
    private String jwtToken;
}
