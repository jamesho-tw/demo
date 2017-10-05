package com.example.data.user.service;

import com.example.data.user.model.entity.User;
import java.util.Collection;

public interface UserService {

  User create(User user);

  User read(String name);

  Collection<User> readAll();

  Collection<User> readAll(int status);

}
