package com.example.bootcrudpostgresqlback.controller;

import com.example.bootcrudpostgresqlback.record.UserDTO;
import com.example.bootcrudpostgresqlback.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
    Optional<UserDTO> user = userService.getUserById(id);
    return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public UserDTO createUser(@RequestBody UserDTO userDTO) {
    return userService.createUser(userDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
    try {
       UserDTO updatedUser = userService.updateUser(id, userDTO);
       return ResponseEntity.ok(updatedUser);
    } catch (Exception e) {
      System.out.println("Error al actualizar: " + e);
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("{id}")
  public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
    try {
      UserDTO deletedUser = userService.deleteUser(id);
      return ResponseEntity.ok(deletedUser);
    } catch (Exception e) {
      System.out.println("Error al eliminar: " + e);
      return ResponseEntity.notFound().build();
    }
  }
}
