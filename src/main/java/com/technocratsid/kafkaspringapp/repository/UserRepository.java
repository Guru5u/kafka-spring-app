package com.technocratsid.kafkaspringapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.technocratsid.kafkaspringapp.bean.User;


public interface UserRepository extends MongoRepository<User, String>{

}
