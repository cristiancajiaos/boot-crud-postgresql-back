package com.example.bootcrudpostgresqlback.service;

import com.example.bootcrudpostgresqlback.record.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {

  List<UserDTO> getAllUsers();

  Optional<UserDTO> getUserById(Long id);

  UserDTO createUser(UserDTO userDTO);

  UserDTO updateUser(Long id, UserDTO userDTO);

  UserDTO deleteUser(Long id);
}
