package com.example.data.user.repository;

import com.example.data.user.model.entity.User;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);

  Collection<User> findByStatus(int status);

}
