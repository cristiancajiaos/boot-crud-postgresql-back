package com.example.bootcrudpostgresqlback.repository;

import com.example.bootcrudpostgresqlback.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
