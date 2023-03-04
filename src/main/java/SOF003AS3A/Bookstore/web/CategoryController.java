package SOF003AS3A.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.Category;
import SOF003AS3A.Bookstore.domain.CategoryRepositery;

@Controller
public class CategoryController {
@Autowired
CategoryRepositery categoryRepositery;

@RequestMapping("/categorylist")
public String categoryList(Model model) {

	model.addAttribute("categories", categoryRepositery.findAll());

	return "categorylist";
}


@RequestMapping(value="/addcategory")
public String addCategory(Model model) {
	
	model.addAttribute("category", new Category());
	return "addcategory";
}



@RequestMapping(value = "/save-category", method = RequestMethod.POST)

public String saveCategory(Category category) {
	categoryRepositery.save(category);
	return "redirect:categorylist";
}

}










