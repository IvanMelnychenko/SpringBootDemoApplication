package com.gmail.liftiwan1996.springbootdemo.controller;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import com.gmail.liftiwan1996.springbootdemo.service.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


  private final UserServiceImpl userService;

  @Autowired
  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    List<User> users = userService.findAll();
    return users;
  }

  @PostMapping("/user-create")
  public void createUserForm(@RequestParam String firstName, @RequestParam String lastName ) {
    User user = new User(firstName,lastName);
    userService.saveUser(user);
  }

  @GetMapping("/user-delete/{id}")
  public List deleteUser(@PathVariable("id") Long id) {
    userService.deleteById(id);
    List<User> users = userService.findAll();
    return users;
  }
}
