package com.gmail.liftiwan1996.springbootdemo.service;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import com.gmail.liftiwan1996.springbootdemo.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findById(Long id) {
    return userRepository.getOne(id);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }
}

