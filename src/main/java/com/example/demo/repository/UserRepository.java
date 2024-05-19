package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<Object> existsByFullNameAndEmail(String name, String email);

    Optional<Object> existsByEmail(String email);
}
