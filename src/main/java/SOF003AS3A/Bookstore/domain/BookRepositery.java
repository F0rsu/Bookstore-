package SOF003AS3A.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepositery extends CrudRepository<Book, Long> {
	 
}
