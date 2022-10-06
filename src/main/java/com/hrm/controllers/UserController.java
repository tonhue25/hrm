package com.hrm.controllers;

import com.hrm.dto.request.UserRequest;
import com.hrm.dto.response.UserResponse;
import com.hrm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return new ResponseEntity<UserResponse>(userService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getUsers() {
        return new ResponseEntity<List<UserResponse>>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getOne(@PathVariable("id") String id){
        return new ResponseEntity<UserResponse>(userService.getOne(id), HttpStatus.OK);
    }
}
