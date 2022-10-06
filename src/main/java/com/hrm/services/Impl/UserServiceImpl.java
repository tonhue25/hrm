package com.hrm.services.Impl;

import com.hrm.dto.request.UserRequest;
import com.hrm.dto.response.UserResponse;
import com.hrm.entities.Role;
import com.hrm.entities.User;
import com.hrm.exceptions.ResourceNotFoundException;
import com.hrm.mappers.UserMapper;
import com.hrm.repository.RoleRepository;
import com.hrm.repository.UserRepository;
import com.hrm.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserResponse create(UserRequest request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        List<Role> roles = (List<Role>) roleRepository.findAllById(request.getRoles());
        User user = modelMapper.map(request, User.class);
        user.setRoles(roles);
        user = userRepository.save(user);
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> list = userRepository.findAll();
        List<UserResponse> result = userMapper.mapListUser(list);
        return result;
    }

    @Override
    public UserResponse getOne(String id){
        Optional<User> optionalUser = userRepository.findByUsername(id);
        if(!optionalUser.isPresent()){
            throw new ResourceNotFoundException(String.format("user.not.found.with.id:%s", id));
        }
        User user = userRepository.findByUsername(id).get();
        return modelMapper.map(user, UserResponse.class);
    }
}
