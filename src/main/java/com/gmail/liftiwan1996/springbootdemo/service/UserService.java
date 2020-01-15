package com.gmail.liftiwan1996.springbootdemo.service;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import java.util.List;

public interface UserService {

  User findById(Long id);

  List<User> findAll();

  User saveUser(User user);

  void deleteById(Long id);

}
