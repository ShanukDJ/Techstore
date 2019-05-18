package com.sellnbye.inventoryservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sellnbye.inventoryservice.model.Type;
import com.sellnbye.inventoryservice.service.TypeService;

@Controller
public class AppController {

	@Autowired
	TypeService typeService;
	
	@RequestMapping("/types")
	/* Model use from spring mvc */
	public String viewTypes(Model model) { 
		
		List<Type> listTypes = typeService.listAll();
		model.addAttribute("listTypes", listTypes);
		return "types";
		
	}
	
}
