package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Category;
import com.example.demo.constants.MedicareConstants;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.utils.MedicareUtils;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public ResponseEntity<String> addCategory(String categoryname) {
		try {
			Category category = new Category();
			category.setCategoryname(categoryname);
			categoryRepository.save(category);
			return MedicareUtils.getResponseEntity("Category SuccessFully Addedd.", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Category> getCategories() {

		return categoryRepository.findAll();
	}

	@Override
	public ResponseEntity<String> removeCategory(int id) {
		try {
			categoryRepository.deleteById(id);
			return MedicareUtils.getResponseEntity("Category Deleted SuccessFully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public List<Category> updateCategory(int id, String categoryName) {
		try {
			Category category = new Category();
			category.setCategoryid(id);
			category.setCategoryname(categoryName);

			categoryRepository.save(category);

			return getCategories();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			//return MedicareUtils.getResponseEntity(MedicareConstants.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
