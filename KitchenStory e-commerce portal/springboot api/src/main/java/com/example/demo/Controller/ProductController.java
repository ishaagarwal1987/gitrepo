package com.example.demo.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository; 
	String uploadDir = "D:\\eclipse workspace\\FoodItemSale\\src\\main\\resources\\static\\productImages";
	
	@PostMapping
	public ResponseEntity<String> addNewProduct(@RequestParam("addProduct") String productObj,@RequestParam(value = "image") MultipartFile file)
	{
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.readValue(productObj,Product.class);
			product.setImageName(file.getOriginalFilename());
			//product.setImageData(file.getBytes());
			
			
			FileUploadUtil.saveFile(uploadDir, product.getImageName(), file);
			
			productRepository.save(product);
			return ResponseEntity.status(HttpStatus.OK).body("Product Added Successfully!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("");
		}
		
	}
	
	@GetMapping
	public List<Product> getAllProducts()
	{
		return (List<Product>) productRepository.findAll();
	}
	
	@DeleteMapping("/{id}")
	public List<Product> deleteProduct(@PathVariable("id") int id)
	{
	
		Product removeProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		
		File myObj = new File(uploadDir+File.separator +removeProduct.getImageName()); 
	    if (myObj.delete()) { 
	      System.out.println("Deleted the folder: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the folder.");
	    } 
		
		productRepository.deleteById(id);
		return getAllProducts();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id,@RequestParam("updateProduct") String productObj,@RequestParam(value = "image") MultipartFile file) {
		
		Product changeProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.readValue(productObj,Product.class);
			
			
			if(!changeProduct.getImageName().equals(product.getImageName()))
					{
				FileUploadUtil.saveFile(uploadDir, product.getImageName(), file);
				product.setImageName(file.getOriginalFilename());
				
				File myObj = new File(uploadDir+File.separator +changeProduct.getImageName()); 
			    if (myObj.delete()) { 
			      System.out.println("Deleted the folder: " + myObj.getName());
			    } else {
			      System.out.println("Failed to delete the folder.");
			    } 
					}
		
		productRepository.save(product);
		
		return ResponseEntity.status(HttpStatus.OK).body("Product Updated Successfully!!");
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Could not update the product");
		}
		
	}

}
