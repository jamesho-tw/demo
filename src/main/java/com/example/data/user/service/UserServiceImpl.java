package com.example.data.user.service;

import com.example.data.user.model.entity.User;
import com.example.data.user.repository.UserRepository;
import java.util.Collection;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

  protected static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) {
    if (user == null) {
      return null;
    }
    user.setCreated(new Date());
    return userRepository.saveAndFlush(user);
  }

  @Override
  public User read(String name) {
    return userRepository.findByName(name);
  }

  @Override
  public Collection<User> readAll() {
    return userRepository.findAll();
  }

  @Override
  public Collection<User> readAll(int status) {
    return userRepository.findByStatus(status);
  }

}
