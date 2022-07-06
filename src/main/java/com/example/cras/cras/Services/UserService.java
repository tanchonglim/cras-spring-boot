package com.example.cras.cras.Services;

import com.example.cras.cras.Models.User;
import com.example.cras.cras.Models.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private final UserRepository userRepository;


	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		Iterable<User> source = userRepository.findAll();
		List<User> target = new ArrayList<User>();
		source.forEach(target::add);
		return target;
	}

	public boolean updateEmailAndName(long id,  User user) {
		Optional<User> optionalCurrentUser = userRepository.findById(id);
		if (!optionalCurrentUser.isPresent())
			return false;

		User currentUser = optionalCurrentUser.get();
		currentUser.setEmail(user.getEmail());
		currentUser.setUsername(user.getUsername());
		userRepository.save(currentUser);
		return true;
	}
}
