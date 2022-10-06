package com.hrm.services;

import com.hrm.dto.request.UserRequest;
import com.hrm.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest request);

    List<UserResponse> getAll();

    UserResponse getOne(String id);
}
