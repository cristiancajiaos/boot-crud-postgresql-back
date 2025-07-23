package com.example.bootcrudpostgresqlback.service;

import com.example.bootcrudpostgresqlback.record.UserDTO;
import java.util.List;

public interface UserService {

  List<UserDTO> getAllUsers();
}
