package com.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.core.entity.User;
import com.core.entity.UserProfile;
import com.core.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService implements CommandLineRunner {

	private final UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("user service executed");

		UserProfile profile = new UserProfile("Software Developer", "Pune, India");
		User user = new User("sangam123", "sangam@gmail.com", profile);
		System.out.println(user);
		userRepository.save(user);

	}

}
