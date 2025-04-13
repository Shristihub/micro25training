package com.userinfo.service;

import com.userinfo.model.UserDTO;

public interface IUserService {
	
	String registerUser(UserDTO userDTO);
	UserDTO loginUser(String email,String password);
	UserDTO findByUserId(int userId);

}
