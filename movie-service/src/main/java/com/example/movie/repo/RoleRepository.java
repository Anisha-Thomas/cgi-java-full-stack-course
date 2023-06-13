package com.example.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}