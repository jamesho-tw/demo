package com.example.demo.controller.rest;

import com.example.data.user.model.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserRestController {

  protected static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

  @RequestMapping(value = "/profile", method = RequestMethod.GET)
  public ResponseEntity<?> readProfile() {
    Collection<User> users = new ArrayList<User>();
    users.add(new User("user1", "password", "salt", true));
    users.add(new User("user2", "password", "salt", true));

    logger.debug(String.format("USER SIZE: %d", users.size()));

    return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
  }

}
