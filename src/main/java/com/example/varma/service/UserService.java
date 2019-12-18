package com.example.varma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.varma.dao.UserRepository;
import com.example.varma.entity.UserEntity;
import com.example.varma.vo.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public void saveUser(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setAge(user.getAge());
		userEntity.setGender(user.getGender());
		userEntity.setCity(user.getCity());

		userRepository.save(userEntity);
	}


}
