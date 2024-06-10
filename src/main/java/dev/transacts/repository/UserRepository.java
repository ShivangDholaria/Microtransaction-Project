package dev.transacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.transacts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
}
