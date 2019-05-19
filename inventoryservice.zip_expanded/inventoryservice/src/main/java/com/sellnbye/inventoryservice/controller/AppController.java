package com.sellnbye.inventoryservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sellnbye.inventoryservice.model.Type;
import com.sellnbye.inventoryservice.model.product;
import com.sellnbye.inventoryservice.service.ProductService;
import com.sellnbye.inventoryservice.service.TypeService;

@Controller
public class AppController {

	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String home() {
		
		return "index";
		
	}

	@GetMapping("products")
	public String products(Model model) {
		Optional<List<product>> proALL = productService.getALL();
		if (proALL.isPresent()) {
			model.addAttribute("proALL", proALL.get());
			return "MainPage";
		} else {
			model.addAttribute("flag", "No Record Found");
			return "MainPage";
		}
	}
	
	@PostMapping("addProduct")
	public String addProduct(Model model, product prod) {
		model.addAttribute("prod", prod);
		return "AddProduct";
	}
	
	@PostMapping("editProduct")
	public String editProduct(Model model, int id) {
		model.addAttribute("prod", productService.get(id));
		return "EditProduct";
	}
	
	@PostMapping("processAddProduct")
	public String processAddProduct(Model model, product prod) {
		model.addAttribute("info", productService.addOne(prod));
		Optional<List<product>> proALL = productService.getALL();
		model.addAttribute("proALL", proALL.get());
		return "MainPage";
	}
	
	@PostMapping("processEditProduct")
	public String processEditProduct(Model model, product prod) {
		model.addAttribute("info", productService.editOne(prod));
		Optional<List<product>> proALL = productService.getALL();
		model.addAttribute("proALL", proALL.get());
		return "MainPage";
	}
	
	@PostMapping("deleteProduct")
	public String deleteProduct(Model model, int id) {
		model.addAttribute("info", productService.deleteOne(id));
		Optional<List<product>> proALL = productService.getALL();
		if(proALL.isPresent()) {
			model.addAttribute("proALL", proALL.get());
			return "MainPage::section";
		}else {
			model.addAttribute("flag", "No Record Found");
			return "MainPage::section";
		}
	}

}
