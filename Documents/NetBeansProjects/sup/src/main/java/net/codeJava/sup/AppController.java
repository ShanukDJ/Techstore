package net.codeJava.sup;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController 
{
	 private SupplierService service;
	 
	 @RequestMapping("/")
	 public String viewHomePage(Model model)
	 {
		List<Supplier> listSupplier = service.listAll();
		model.addAttribute("listSupplier",listSupplier);
		return  "index";
	 }
	@RequestMapping("/new") 
	 public String showNewSupplierForm(Model model)
	 {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		 return "new_supplier";
	 }
	
	@RequestMapping(value ="/save",method = RequestMethod.POST)
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier)
	{  
		service.save(supplier);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}") 
	 public ModelAndView showEditSupplierForm(@PathVariable(name = "id") int id)
	 {
		ModelAndView mav = new ModelAndView("edit_supplier"); 
		
		Supplier supplier = service.get(id);
		mav.addObject("supplier", supplier);
		return mav;
	 }
	
	@RequestMapping("/delete/{id}") 
	public String deleteSupplier(@PathVariable(name = "id") Long id)
	{
		service.delete(id);
		return "redirect:/";
	}

} 
