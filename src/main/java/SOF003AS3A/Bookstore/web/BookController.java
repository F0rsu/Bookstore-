package SOF003AS3A.Bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BookController {


	@GetMapping("/Bookstore")

	public String Getmessage(Model model) {
		model.addAttribute("message", "Welcome to the bookstore!");
		
	
		return "Bookstore";
}
}