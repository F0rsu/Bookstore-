package SOF003AS3A.Bookstore.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}