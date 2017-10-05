package com.example.demo.controller.rest;

import com.example.data.user.model.entity.User;
import com.example.data.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserRestController {

  protected static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

  @Autowired
  private UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseEntity<?> readAll() {
    Collection<User> users = userService.readAll();
    if (users == null) {
      // TODO: return error message
    }
    logger.debug(String.format("USER SIZE: %d", users.size()));
    return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public ResponseEntity<?> readByName(@PathVariable("name") String name) {
    if (StringUtils.isEmpty(StringUtils.trimToNull(name))) {
      return new ResponseEntity<String>("Invalid argument", HttpStatus.BAD_REQUEST);
    }
    User user = userService.read(name);
    if (user == null) {
      return new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);
    }
    logger.debug(String.format("USER: %s", user.toString()));
    return new ResponseEntity<User>(user, HttpStatus.OK);
  }

  /*
  for example:
  $ curl -v -X POST http://localhost:8080/user/add -H "Content-Type: application/json" \
  -d '{"name": "james", "password": "123456", "salt": "XXX", "mustChangePassword": true, "status": 1}'
  */
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<?> create(@RequestBody User user) {
    // TODO: validation

    return new ResponseEntity<User>(userService.create(user), HttpStatus.OK);
  }

}
