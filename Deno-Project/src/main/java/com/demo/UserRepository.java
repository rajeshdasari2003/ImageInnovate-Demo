package com.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
