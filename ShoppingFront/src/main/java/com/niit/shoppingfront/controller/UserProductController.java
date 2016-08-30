/*package com.niit.shoppingfront.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class UserProductController {
	
	Logger log = LoggerFactory.getLogger(UserProductController.class);

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@RequestMapping(value = "/userProduct", method = RequestMethod.POST)
	public String listCategories(Model model) {
		model.addAttribute("product", product);
		model.addAttribute("productList", this.productDAO.list());
		
		return "user";
	}
	
	

}
*/