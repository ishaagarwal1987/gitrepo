package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.demo.entities.Footwear;
import com.demo.entities.FootwearCategory;
import com.demo.entities.Product;
import com.demo.helper.FileUploadHelper;
import com.demo.repository.FootWearRepository;
import com.demo.repository.FootwearCategoryRepository;

@Controller
public class FootWearController {
	
	@Autowired
	private FileUploadHelper fileUpload;
	
	@Autowired
	private FootWearRepository footwearRepository;
	
	@Autowired
	FootwearCategoryRepository categoryRepository;
	
	Footwear footwear;
	
	@GetMapping("/addFootwear")
	public String addCategory(Model model)
	{
		model.addAttribute("categories",categoryRepository.findAll());
		return "addFootwear";
	}
	
	@GetMapping("/readFootwear")
	public String readFootwear(Model model) {
		
		Iterable<Footwear> footwears =  footwearRepository.findAll();
		model.addAttribute("footwears",footwears);
		return "displayFootwears";
	}
	
	
	@GetMapping("/deleteFootwear/{id}")
	public String deleteFootwear(@PathVariable(value = "id") int id,Model model)
	{
		footwearRepository.deleteById(id);
		
		return "redirect:/readFootwear";
	}
	
	@GetMapping("/showFormForUpdateFootwear/{id}")
    public String updateForm(@PathVariable(value = "id") int id, Model model) {
		Optional<Footwear> optional = footwearRepository.findById(id);
		Footwear fc = optional.get();
		footwear = fc;
        return "redirect:/updateFootwear";
    }
	
	@GetMapping("/updateFootwear")
	public String updateform(Model model)
	{
		model.addAttribute("categories",categoryRepository.findAll());
		model.addAttribute("footwear",footwear);
		return "updateFootwearForm";
	}
	
	 @PostMapping("/saveFootwear")
	    public String updateFootwear(@RequestParam("img_name") MultipartFile file,@ModelAttribute Product product,Model model) {
		 Footwear footwear = new Footwear();
			try {
			
			if(file.isEmpty())
			{
				model.addAttribute("msg", "File is empty.");
				return "home";
			}
			else
			{
				boolean status = fileUpload.uploadFile(file);
				if(status)
					model.addAttribute("msg","File Upload Successful");
				else
					model.addAttribute("msg","Sorry");
			}
			
			footwear.setFootwear_id(product.getFootwear_id());
			footwear.setName(product.getName());
			footwear.setPrice(product.getPrice());
			footwear.setBrand(product.getBrand());
			footwear.setIsMale(product.getIsMale());
			footwear.setImg_name(file.getOriginalFilename());
			footwear.setCategory(product.getCategory());
			
			footwearRepository.save(footwear);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        return "redirect:/readFootwear";
	    }
	
	@PostMapping("/submitFootwear")
	public String submitFootwear(@RequestParam("img_name") MultipartFile file,@ModelAttribute Product product,Model model)
	{
		Footwear footwear = new Footwear();
		try {
		
		if(file.isEmpty())
		{
			model.addAttribute("msg","File is empty");
			return "home";
		}
		else
		{
			boolean status = fileUpload.uploadFile(file);
			if(status)
				model.addAttribute("msg","File Upload Successful");
			else
				model.addAttribute("msg","Sorry");
		}
		
		footwear.setName(product.getName());
		footwear.setPrice(product.getPrice());
		footwear.setBrand(product.getBrand());
		footwear.setIsMale(product.getIsMale());
		footwear.setImg_name(file.getOriginalFilename());
		footwear.setCategory(product.getCategory());
		
		footwearRepository.save(footwear);
		model.addAttribute("msg","Footwear added successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
	
	@GetMapping("/footwearByCategory")
	public String footwearByCategory(Model model)
	{
		model.addAttribute("categories",categoryRepository.findAll());
		return "footwearsByCategory";
	}

	@PostMapping("/sendCategory")
	public String findFootwearByCategory(Model model,@RequestParam("category") int id )
	{
		Optional<FootwearCategory> optional = categoryRepository.findById(id);
		FootwearCategory fc = optional.get();
		Iterable<Footwear> footwears = footwearRepository.findByCategory(fc);
		model.addAttribute("footwears",footwears);
		model.addAttribute("categories",categoryRepository.findAll());
		return "footwearsByCategory";
	}
}
