package com.example.bootcrudpostgresqlback.service;

import com.example.bootcrudpostgresqlback.entity.User;
import com.example.bootcrudpostgresqlback.record.UserDTO;
import com.example.bootcrudpostgresqlback.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
  }

  private UserDTO convertToDTO(User user) {
    return new UserDTO(user.getId(), user.getName());
  }

  private User convertToEntity(UserDTO userDTO) {
    User user = new User();
    user.setId(user.getId());
    user.setName(userDTO.name());
    return user;
  }
}
