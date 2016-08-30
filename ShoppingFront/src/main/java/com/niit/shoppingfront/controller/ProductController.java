package com.niit.shoppingfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {

	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired(required = true)
	private CategoryDAO categoryDAO;

	@Autowired(required = true)
	private SupplierDAO supplierDAO;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("productList", this.productDAO.list());
		/*model.addAttribute("category", new Category());
		model.addAttribute("categoryList", this.categoryDAO.list());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("supplierList", this.supplierDAO.list());*/
		
		return "product";
	}
	
	// For add and update Product
			@RequestMapping(value = "/product/add", method = RequestMethod.POST)
			public String addProduct(@ModelAttribute("product") Product product) {
				
				/*Category category = categoryDAO.getByName(product.getCategory_id());
				categoryDAO.saveOrUpdate(category); 

				Supplier supplier = supplierDAO.getByName(product.getSupplier_id());
				supplierDAO.saveOrUpdate(supplier);

				product.setCategory_id(category.getId());
				product.setSupplier_id(supplier.getId());*/
				productDAO.saveOrUpdate(product);

				return "redirect:/manageProducts";
			}
			
			@RequestMapping("product/remove/{id}")
			public String deleteProduct(@PathVariable("id") int id, ModelMap model)  {
				
				productDAO.delete(id);
				model.addAttribute("message", "Successfully Deleted");
				return "redirect:/manageProducts";
			}
			
			@RequestMapping("product/edit/{id}")
			public String editProduct(@PathVariable("id") int id, Model model) {
				System.out.println("editProduct");
				model.addAttribute("product", this.productDAO.get(id));
				model.addAttribute("listProduct", this.productDAO.list());
				
				return "product";
			}
			
		/*	@RequestMapping(value = "product/get/{id}")
			public String getSelectedProduct(@PathVariable("id") String id, Model model) {
				model.addAttribute("selectedProduct", this.productDAO.get(id));
				model.addAttribute("categoryList", this.categoryDAO.list());

				return "redirect:/index";

			}*/
			
}
