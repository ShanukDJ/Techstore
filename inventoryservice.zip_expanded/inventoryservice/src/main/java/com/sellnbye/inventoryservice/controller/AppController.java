package com.sellnbye.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sellnbye.inventoryservice.service.TypeService;

@Controller
public class AppController {

	@Autowired
	TypeService typeService;
	
	public String viewTypes() {
		
	}
	
}
