package com.hackathon.api;

import com.hackathon.api.Service.impl.UserImpl;
import com.hackathon.api.model.Role;
import com.hackathon.api.model.dao.UserDao;
import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


}
