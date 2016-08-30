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

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {

	Logger log = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	
	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public String listSuppliers(Model model) {
		model.addAttribute("supplier", supplier);
		model.addAttribute("supplierList", this.supplierDAO.list());
		return "supplier";
	}

	//For add and update supplier both
		@RequestMapping(value= "/supplier/add", method = RequestMethod.POST)
		public String addSupplier(@ModelAttribute("supplier") Supplier supplier){
		
			supplierDAO.saveOrUpdate(supplier);
			
			return "redirect:/manageSuppliers";
			
		}
		
		@RequestMapping("supplier/remove/{id}")
	    public String removeSupplier(@PathVariable("id") int id,ModelMap model) throws Exception{

			supplierDAO.delete(id);
			model.addAttribute("message","Successfully Added");

			return "redirect:/manageSuppliers";
	    }
	 
	    @RequestMapping("supplier/edit/{id}")
	    public String editSupplier(@PathVariable("id") int id, Model model){
	    	System.out.println("editSupplier");
	        model.addAttribute("supplier", this.supplierDAO.get(id));
	        model.addAttribute("listSuppliers", this.supplierDAO.list());
	        return "supplier";
	    }
}

