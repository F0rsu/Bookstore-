package SOF003AS3A.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.BookRepositery;
import jakarta.persistence.Column;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData (BookRepositery bookRepositery) {
		return (arg) -> {
			Book book1 = new Book(0, "Joo", "Joo-mies", 1823, "aaaa", 200);
	    	bookRepositery.save(book1); // SQL Insert
	       
	
		
	         
		
		
		};
}
}