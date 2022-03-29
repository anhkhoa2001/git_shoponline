package fpt.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fpt.spring.model.Account;
import fpt.spring.model.Category;
import fpt.spring.repository.CategoryRespository;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRespository categoryRespository;
	
	public List<Category> findAll() {
		return categoryRespository.findAll();
	}
	
	public Category findCategory(String code) {
		int id = 0;
		List<Category> list = findAll();
		for(Category category:list) {
			if(category.getCode() != null && code.contains(category.getCode())) {
				id = category.getId();
			}
		}
		return categoryRespository.findOne(id);
	}
	
	public List<Category> getAllCategoryBycmID(int cmID) {
		List<Category> list = findAll();
		List<Category> list2 = new ArrayList<>();
		for(Category category:list) {
			if(category.getCatemenu().getId() == cmID) {
				list2.add(category);
			}
		}
		
		return list2;
	}
}
