package demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	List<User> findByFirstName(String firstName);

	User findByEmail(String email);
	
}
