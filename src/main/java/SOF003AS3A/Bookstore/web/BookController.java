package SOF003AS3A.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String bookList(Model model) {

		model.addAttribute("books", bookRepositery.findAll());

		return "booklist";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {

		bookRepositery.deleteById(bookId);
		return "redirect:../booklist";

	}

	@RequestMapping(value="/addbook")
	public String addBook(Model model) {
		
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)

	public String saveBook(Book book) {
		bookRepositery.save(book);
		return "redirect:booklist";
	}


	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
	  Book book = bookRepositery.findById(bookId).orElse(null);
	  model.addAttribute("book", book);
	  return "editbook";
	}


}