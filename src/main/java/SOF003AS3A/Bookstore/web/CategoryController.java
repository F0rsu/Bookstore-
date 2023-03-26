package SOF003AS3A.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import SOF003AS3A.Bookstore.domain.Book;
import SOF003AS3A.Bookstore.domain.Category;
import SOF003AS3A.Bookstore.domain.CategoryRepositery;

@CrossOrigin
@Controller
public class CategoryController {
@Autowired
CategoryRepositery categoryRepositery;

@RequestMapping("/categorylist")
public String categoryList(Model model) {

	model.addAttribute("categories", categoryRepositery.findAll());

	return "categorylist";
}


//RESTful service to get all categories
@RequestMapping(value="/categories", method = RequestMethod.GET)
public @ResponseBody List<Category> getCategoriesRest() {	
    return (List<Category>) categoryRepositery.findAll();
}    



//RESTful service to get category by id
@RequestMapping(value="/categories/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Category> findCategoryRest(@PathVariable("id") Long categoryId) {	
	return categoryRepositery.findById(categoryId);
} 


// RESTful service to save new category
@RequestMapping(value="/categories", method = RequestMethod.POST)
public @ResponseBody Category saveBookRest(@RequestBody Category category) {	
	return categoryRepositery.save(category);
}



@RequestMapping(value="/addcategory")
public String addCategory(Model model) {
	
	model.addAttribute("category", new Category());
	return "addcategory";
}



@RequestMapping(value = "/save-category", method = RequestMethod.POST)

public String saveCategory(Category category) {
	categoryRepositery.save(category);
	return "redirect:/categorylist";
}

}










