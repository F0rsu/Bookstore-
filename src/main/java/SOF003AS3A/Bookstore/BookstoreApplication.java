package SOF003AS3A.Bookstore;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.BookRepositery;
import SOF003AS3A.Bookstore.domain.Category;
import SOF003AS3A.Bookstore.domain.CategoryRepositery;
import SOF003AS3A.Bookstore.domain.User;
import SOF003AS3A.Bookstore.domain.UserRepositery;







@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
			public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData (BookRepositery bookRepositery, CategoryRepositery categoryRepositery, UserRepositery userRepositery) {
		return (arg) -> {
			    
	   	
  	
		
	         Category category1 = new Category(1, "Scifi");
	         Category category2 = new Category (2, "Fantasy");
	         categoryRepositery.save(category1);
	         categoryRepositery.save(category2);
		
	         
	         bookRepositery.save(new Book(0, "Joulumaa", "Joulupukki", 1832, "23344-12", 12.34, category2));
				
				
	         User user1 = new User("user", "$2a$10$uK4W7azkha3kQ2Ys44/NPO8lqa6qm4.5eaPdqb/wryJA.vY0MP3Ry", "USER");
				User user2 = new User("admin", "$2a$10$0hlacwZxQQGV4bbKp8avAe6BFEOtuteliAEZz2ghejXxSKQKwzO8i", "ADMIN");
				userRepositery.save(user1);
				userRepositery.save(user2);
				
				
				
				
				for (Book book : bookRepositery.findAll()) {
					log.info(book.toString());
	         
	         
	        
   
		       };
};
};

	

	
	
	
	
	}
