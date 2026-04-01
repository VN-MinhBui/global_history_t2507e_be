package com.example.globalhistorybe.repository;

import com.example.globalhistorybe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
