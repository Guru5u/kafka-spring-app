package com.technocratsid.kafkaspringapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technocratsid.kafkaspringapp.bean.User;
import com.technocratsid.kafkaspringapp.repository.UserRepository;
// import com.technocratsid.kafkaspringapp.repository.UserRepository;

@Service
@Transactional
public class UserServiceImp implements UserService {
	@Autowired
	UserRepository userRepository;

	public void createUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	public List<User> getQuotes() {
		// TODO Auto-generated method stub
		System.out.println("In USer service Impl ");
		return (List<User>) userRepository.findAll();
	}

	public Optional<User> findById(String id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	public User update(User user, String l) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	public void deleteUserById(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

//	public User updatePartially(User user, String id) {
//		// TODO Auto-generated method stub
//		Optional<User> usr = findById(id);
//		usr.setCountry(user.getCountry());
//		return userRepository.save(usr);
//	}



}
