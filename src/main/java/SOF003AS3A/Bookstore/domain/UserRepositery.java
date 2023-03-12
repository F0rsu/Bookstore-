package SOF003AS3A.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import SOF003AS3A.Bookstore.domain.User;

public interface UserRepositery extends CrudRepository<User, Long> {
	User findByUsername(String username);  //Springin tekemää  sisäänkirjatumistestiä varten
}
