package com.userinfo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="UserDetails")
public class User {
	@Id
	@GeneratedValue(generator = "user_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "user_gen",sequenceName = "user_seq", initialValue = 10,allocationSize = 1)
	private Integer userId;
	@Column(length=30)
	private String username;
	@Column(nullable = false,unique = true,length=30)
	private String email;
	@Column(nullable = false,length=30)
	private String password;
	
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}

}















