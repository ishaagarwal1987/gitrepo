package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.Category;
import com.example.demo.Model.Product;
import com.example.demo.constants.MedicareConstants;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import com.example.demo.utils.MedicareUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
			
	@Override
	public ResponseEntity<String> addProduct(String productObj, MultipartFile file) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.readValue(productObj, Product.class);
			
			product.setImage(file.getOriginalFilename());

			MedicareUtils.saveFile(product.getImage(), file);

			productRepository.save(product);
			return MedicareUtils.getResponseEntity("Product added SuccessFully", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Product> getProducts() {

		return productRepository.findAll();
	}

	@Override
	public ResponseEntity<String> removeProduct(int id) {
		try {
			Product removeProduct = productRepository.findById(id).orElseThrow(null);

			MedicareUtils.deleteFile(removeProduct.getImage());

			productRepository.deleteById(id);
			return MedicareUtils.getResponseEntity("Product deleted SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<String> updateProduct(String productObj, MultipartFile file) {

		try {
			//Product changeProduct = productRepository.findById(id).orElseThrow(null);

			ObjectMapper mapper = new ObjectMapper();
			Product product = mapper.readValue(productObj, Product.class);
			Product changeProduct = productRepository.findById(product.getPid()).orElseThrow(null);
			
			
			//if (changeProduct != null && !changeProduct.getImage().equals(file.getOriginalFilename())) {
			MedicareUtils.deleteFile(changeProduct.getImage());	
			MedicareUtils.saveFile(product.getImage(), file);
			product.setImage(file.getOriginalFilename());
				
			//}
			
			productRepository.save(product);
			return MedicareUtils.getResponseEntity("Product Updated SuccessFully", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		
	}

	@Override
	public ResponseEntity<String> updateStatus(int id, Product product) {
		
		try {
			//Product product = productRepository.findById(id).orElseThrow(null);
			
			if(product!=null)
			{
				//product.setStatus(status);
				productRepository.save(product);
				return MedicareUtils.getResponseEntity("Product Status Updated SuccessFully", HttpStatus.OK);
			}
			return MedicareUtils.getResponseEntity("Product does not exist.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public List<Product> getActiveProducts() {
		return productRepository.findByActiveStatus();
	}

	@Override
	public List<Product> getProductsByCategory(int categoryId) {
		try {
			
			Category category = categoryRepository.findById(categoryId).orElseThrow(null);
			
			return productRepository.findByCategory(category);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public List<Product> getFewProducts() {
		try {
			return productRepository.findFewProducts();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
