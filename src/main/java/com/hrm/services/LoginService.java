package com.hrm.services;

import com.hrm.dto.request.LoginRequest;
import com.hrm.dto.response.JwtResponse;

public interface LoginService {
    JwtResponse login(LoginRequest loginRequest);
}
