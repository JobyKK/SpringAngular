package demo.service;

import java.util.List;

import demo.model.User;

public interface UserService {

	List<User> getUsers();

	User getUserByEmail(String email);

	void addUser(User user);

	void updateUser(User user);

}
