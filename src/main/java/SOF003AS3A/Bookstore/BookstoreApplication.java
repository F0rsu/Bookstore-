package SOF003AS3A.Bookstore;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.BookRepositery;




@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demoData (BookRepositery bookRepositery) {
		return (arg) -> {
			  Book book1 = new Book(1, "Eläinten vallankumous", "George Orwell", 1945, "9780151002177", 12);
			  Book book2 =new Book(2,"Rikos ja rangaistus", "Fjodor Dostojevski", 1866 , "9788726021226", 34);
			  bookRepositery.save(book1); // SQL Insert
			  bookRepositery.save(book2);    
	   	
  	List<Book> books = (List<Book>)bookRepositery.findAll();
	       for (Book book: books) {
	        System.out.println(book.toString());
		
	         
		
		
		};
};
}
}