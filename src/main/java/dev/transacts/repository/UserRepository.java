package dev.transacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.transacts.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
}
