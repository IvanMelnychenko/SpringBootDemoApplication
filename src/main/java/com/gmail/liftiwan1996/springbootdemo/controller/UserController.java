package com.gmail.liftiwan1996.springbootdemo.controller;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import com.gmail.liftiwan1996.springbootdemo.service.UserService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String findAll(Model model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "user-list";
  }

  @GetMapping("/user-create")
  public String createUserForm(User user) {
    return "user-create";
  }

  @PostMapping
  public String createUser(User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }
}
