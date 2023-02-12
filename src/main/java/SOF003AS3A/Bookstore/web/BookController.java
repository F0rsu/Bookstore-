package SOF003AS3A.Bookstore.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.BookRepositery;








@Controller
public class BookController {
   @Autowired 
   BookRepositery bookRepositery;
   
   

	@GetMapping("/Bookstore")

	public String Getmessage(Model model) {
		model.addAttribute("message", "Welcome to the bookstore!");
		
	
		return "Bookstore";
}



@RequestMapping("/booklist")
public String bookList (Model model) {
	
	model.addAttribute("books", bookRepositery.findAll());
	
	
	return "booklist";
	
	
}




	
	}


