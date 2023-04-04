package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.entities.Footwear;
import com.demo.entities.Stock;
import com.demo.repository.FootWearRepository;
import com.demo.repository.StockRepository;

@Controller
public class StockController {
	
	@Autowired
	private FootWearRepository footwearRepository;
	
	@Autowired
	private StockRepository stockRepository;
	
	Stock stock;
	
	@GetMapping("/stock")
	public String stock(Model model)
	{
		Iterable<Footwear> footwears =  footwearRepository.findAll();
		model.addAttribute("footwears",footwears);
		
		Iterable<Stock> stocks = stockRepository.findAll();
		model.addAttribute("stocks", stocks);
		return "stock";
	}
	
	@PostMapping("/addStock")
	public String addStock(@ModelAttribute Stock stock)
	{
		stockRepository.save(stock);
		return "redirect:/stock";
	}
	
	@GetMapping("/showFormForUpdateStock/{id}")
	public String updateStock(@PathVariable(value = "id") int id, Model model)
	{
		Optional<Stock> optional = stockRepository.findById(id);
		stock = optional.get();
		return "redirect:/updateStock";
	}
	
	@GetMapping("/updateStock")
	public String updateStockPage(Model model)
	{
		model.addAttribute("stock", stock);
		model.addAttribute("footwears",footwearRepository.findAll());
		return "updateStock";
	}
	
	@GetMapping("/deleteStock/{id}")
	public String deleteStock(@PathVariable(value = "id") int id,Model model)
	{
		stockRepository.deleteById(id);
		return "redirect:/stock";
	}
	
	

}
