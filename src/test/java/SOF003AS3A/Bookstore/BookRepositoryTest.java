package SOF003AS3A.Bookstore;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.Category;

import SOF003AS3A.Bookstore.domain.BookRepositery;



@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class BookRepositoryTest {

	
	 @Autowired
	    private BookRepositery repository;
	
	 
	    
	    @Test // testataan StudentRepositoryn save()-metodin toimivuutta
	    public void createNewBook() {
	    	Book book = new Book(1, "Idiootti", "Fjodor Dostojevski", 1868 , "978-951-1-26266-4", 9.90, null);
	    	

	    	
	    	
	    	
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }    

	    
	    
	    @Test 
	    public void deleteNewBook() {
	    	Book book = new Book(1, "Idiootti", "Fjodor Dostojevski", 1868 , "978-951-1-26266-4", 9.90, null);
	    	
	    	repository.delete(book);
	    	assertThat(repository.findById(book.getId())).isEmpty();
	    
	    
	    
	    }
	    
	   /* @Test
	    public void searchByTitle() {
	       
	        Book book1 = new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 1925, "978-0743273565", 7.99, null);
	        Book book2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", 1960, "978-0446310789", 6.99, null);
	        Book book3 = new Book(3, "1984", "George Orwell", 1949, "978-0451524935", 8.99, null);

	       
	        repository.save(book1);
	        repository.save(book2);
	        repository.save(book3);

	        
	        List<Book> results = repository.findByTitleContainingIgnoreCase("mockingbird");

	        
	       assertThat(results).containsOnly(book2);
	   */    
}
