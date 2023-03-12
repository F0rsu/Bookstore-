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







@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
			public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData (BookRepositery bookRepositery, CategoryRepositery categoryRepositery) {
		return (arg) -> {
			    
	   	
  	
		
	         Category category1 = new Category(1, "Scifi");
	         Category category2 = new Category (2, "Fantasy");
	         categoryRepositery.save(category1);
	         categoryRepositery.save(category2);
		
	         
	         bookRepositery.save(new Book(0, "Joulumaa", "Joulupukki", 1832, "23344-12", 12.34, category2));
				
				
				
				
				
				
				
				
				for (Book book : bookRepositery.findAll()) {
					log.info(book.toString());
	         
	         
	        
   
		       };
};
};

	

	
	
	
	
	}
