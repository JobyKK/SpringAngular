package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.model.User;
import demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getUsers(){
		return (List<User>) userRepository.findAll();
	}
	
	@Override
	public User getUserByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	@Override
	public void addUser(User user){
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);
		
	}
	
}
