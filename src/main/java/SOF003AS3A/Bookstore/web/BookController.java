package SOF003AS3A.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.BookRepositery;
import SOF003AS3A.Bookstore.domain.Category;
import SOF003AS3A.Bookstore.domain.CategoryRepositery;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;





@CrossOrigin
@Controller
public class BookController {
	@Autowired
	private BookRepositery bookRepositery;

	
	@Autowired
    private CategoryRepositery categoryRepository;

	
	
	
	@GetMapping("/Bookstore")

	public String Getmessage(Model model) {
		model.addAttribute("message", "Welcome to the bookstore!");

		return "Bookstore";
	}

	@RequestMapping("/booklist")
	public String bookList(Model model) {

		model.addAttribute("books", bookRepositery.findAll());
		model.addAttribute("categories", categoryRepository.findAll());
		return "booklist";}

	
	
	
	
		
	// RESTful service to get all books
    @RequestMapping(value="/students", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) bookRepositery.findAll();
    }    

	
 // RESTful service to get book by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody 
    Optional<Book> findStudentRest(@PathVariable("id") Long bookId) {	
    	return bookRepositery.findById(bookId);
    }      
	

	
    
 // RESTful service to save new book
    @RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody 
    Book saveBookRest(@RequestBody Book book) {	
    	return bookRepositery.save(book);
    }
    
    
 
    
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {

		bookRepositery.deleteById(bookId);
		return "redirect:../booklist";

	
		
	
	}

	
    
	
	@RequestMapping(value="/addbook")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
    	model.addAttribute("categories", categoryRepository.findAll());
        return "addbook";
    
	
}
	
	@RequestMapping(value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepositery.findById(bookId));
    	model.addAttribute("categories", categoryRepository.findAll());
        return "editbook";
    
	
}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public String saveBook(Book book) {
	   
		
		bookRepositery.save(book);
	   
	    return "redirect:booklist";
	    
	
	    
	        
	        
	     
	    }
	
	
	
	@Controller
	public class LoginController {

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }
	}
	
	

	
	
	}


