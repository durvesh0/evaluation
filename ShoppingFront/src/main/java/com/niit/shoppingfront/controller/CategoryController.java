package com.niit.shoppingfront.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

@Controller
public class CategoryController {
	
	
	Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;
	
	@RequestMapping(value = "/categories", method = RequestMethod.POST)
	public String listCategories(Model model) {
		model.addAttribute("category", category);
		model.addAttribute("categoryList", this.categoryDAO.list());
		
		return "category";
	}
	
	// For add and update category both
		@RequestMapping(value = "/category/add", method = RequestMethod.POST)
		public String addCategory(@ModelAttribute("category") Category category) {
			
			categoryDAO.saveOrUpdate(category);

			return "redirect:/manageCategories";
		}
		
		@RequestMapping("category/remove/{id}")
		public String deleteCategory(@PathVariable("id") int id, ModelMap model) throws Exception {
			
			categoryDAO.delete(id);
			model.addAttribute("message", "Successfully Deleted");
				
			return "redirect:/manageCategories";
		}

		@RequestMapping("category/edit/{id}")
		public String editCategory(@PathVariable("id") int id, Model model) {
			System.out.println("editCategory");
			model.addAttribute("category", this.categoryDAO.get(id));
			model.addAttribute("listCategorys", this.categoryDAO.list());
			
			return "category";
		}
}
