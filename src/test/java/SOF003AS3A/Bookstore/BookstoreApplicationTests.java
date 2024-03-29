package SOF003AS3A.Bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.junit.jupiter.SpringExtension;

import SOF003AS3A.Bookstore.web.BookController;

@SpringBootTest
@ExtendWith(SpringExtension.class)   // JUnit5 eli Jupiter
class BookstoreApplicationTests {
	@Autowired
	private BookController bookController;
	
	@Test
	void contextLoads() {
		assertThat(bookController).isNotNull();
	
	
	}

}
