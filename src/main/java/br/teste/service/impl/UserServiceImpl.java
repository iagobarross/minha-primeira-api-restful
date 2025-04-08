package br.teste.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import br.teste.domain.model.User;
import br.teste.domain.repository.UserRepository;
import br.teste.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber()) && userRepository.existsById(userToCreate.getId())) {
			throw new IllegalArgumentException("This account number already exists");
		}
		
	
		return userRepository.save(userToCreate);
	}
}
