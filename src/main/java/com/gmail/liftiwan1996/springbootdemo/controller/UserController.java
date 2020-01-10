package com.gmail.liftiwan1996.springbootdemo.controller;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import com.gmail.liftiwan1996.springbootdemo.service.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  @Autowired
  private final UserServiceImpl userService;

  public UserController(UserServiceImpl userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    List<User> users = userService.findAll();
    return users;
  }

  @GetMapping("/user-create")
  public String createUserForm(User user) {
    return "user create";
  }

  @PostMapping("/user-create")
  public String createUser(User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }

  @GetMapping("/user-delete/{id}")
  public String deleteUser(@PathVariable("id") Long id) {
    userService.deleteById(id);
    return "redirect:/users";
  }
}
