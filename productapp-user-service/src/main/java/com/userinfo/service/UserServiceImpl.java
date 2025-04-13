package com.userinfo.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.exceptions.EmailExistsException;
import com.userinfo.exceptions.EmailNotFoundException;
import com.userinfo.model.User;
import com.userinfo.model.UserDTO;
import com.userinfo.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private IUserRepository userRepository;
	@Autowired
	private ModelMapper mapper;
	
	public UserServiceImpl(IUserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public String registerUser(UserDTO userDTO) {
		Optional<User> userOpt = 
			userRepository.findByEmail(userDTO.getEmail());
		if(userOpt.isPresent())
			throw new EmailExistsException("email already exists");
		
		User user =  mapper.map(userDTO,User.class);
		userRepository.save(user);
		return "User registered";
	}

	@Override
	public UserDTO loginUser(String email, String password) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(()-> new EmailNotFoundException("Invalid email"));
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}

	@Override
	public UserDTO findByUserId(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new RuntimeException("Invalid id"));
		UserDTO userDTO = mapper.map(user, UserDTO.class);
		return userDTO;
	}

}
