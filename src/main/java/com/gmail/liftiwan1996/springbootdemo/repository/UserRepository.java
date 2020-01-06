package com.gmail.liftiwan1996.springbootdemo.repository;

import com.gmail.liftiwan1996.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
