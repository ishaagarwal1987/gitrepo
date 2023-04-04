package com.demo.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.FootwearCategory;
import com.demo.repository.FootwearCategoryRepository;


@Controller
public class FootwearCategoryController {
	
	@Autowired
	FootwearCategoryRepository categoryRepository;
	
	FootwearCategory footwearcategory;

	@PostMapping("/submitCategory")
	public String submitCategory(@ModelAttribute FootwearCategory footwearCategory,Model model) {
		
		categoryRepository.save(footwearCategory);
		model.addAttribute("msg", "Footwear Category added successfully.");
		return "home";
	}
	
	@GetMapping("/readCategory")
	public String readCategory(Model model) {
		
		Iterable<FootwearCategory> categories =  categoryRepository.findAll();
		model.addAttribute("footwearCategories",categories);
		return "displayCategories";
	}
	
	@GetMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable(value = "id") int id,Model model)
	{
		categoryRepository.deleteById(id);
		
		return "redirect:/readCategory";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Optional<FootwearCategory> optional = categoryRepository.findById(id);
		FootwearCategory fc = optional.get();
		footwearcategory = fc;
        return "redirect:/updatePage";
    }
	
	@GetMapping("/updatePage")
	public String updatePage(Model model)
	{
		model.addAttribute("footwearCategory",footwearcategory);
		return "updateFootwearCategory";
	}
	
	@GetMapping("/home")
	public String home(Model model)
	{
		model.addAttribute("msg","");
		return "home";
	}
	
	 @PostMapping("/save")
	    public String updateCategory(@ModelAttribute FootwearCategory footwearCategory) {
		 categoryRepository.save(footwearCategory);
	        return "redirect:/readCategory";
	    }
}
