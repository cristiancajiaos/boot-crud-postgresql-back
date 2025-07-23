package com.example.bootcrudpostgresqlback.controller;

import com.example.bootcrudpostgresqlback.record.UserDTO;
import com.example.bootcrudpostgresqlback.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public List<UserDTO> getAllUsers() {
    return userService.getAllUsers();
  }
}
