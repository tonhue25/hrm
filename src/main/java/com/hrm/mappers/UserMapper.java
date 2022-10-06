package com.hrm.mappers;

import com.hrm.dto.response.UserResponse;
import com.hrm.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public List<UserResponse> mapListUser(List<User> list) {
        List<UserResponse> result = list.stream().map(item -> modelMapper.map(item, UserResponse.class))
                .collect(Collectors.toList());
        return result;
    }
}
