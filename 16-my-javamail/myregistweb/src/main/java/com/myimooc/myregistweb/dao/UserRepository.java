package com.myimooc.myregistweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myimooc.myregistweb.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    User findByCode(String code);

}
