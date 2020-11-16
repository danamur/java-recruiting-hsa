package com.danielnamur.javarecruitinghsa.services;

import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.stereotype.Service;

import com.danielnamur.javarecruitinghsa.converters.CategoryConverted;
import com.danielnamur.javarecruitinghsa.models.CategoryDTO;
import com.danielnamur.javarecruitinghsa.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	CategoryRepository categoryRepo;
	
	CategoryConverted categoryConverter;

	@Override
	public Optional<List<CategoryDTO>> getTopFiveCategories() {
		
		return Optional.ofNullable(preData().subList(0, 5));
	}

	@Override
	public Optional<List<CategoryDTO>> getRemainingCategories() {
		
		List<CategoryDTO> categories = preData();
		
		return Optional.ofNullable(categories.subList(5, categories.size()));
	}
	
	private List<CategoryDTO> preData(){
		
		List<CategoryDTO> categoryList = categoryConverter.convert(categoryRepo.findCategory());
		Collections.sort(categoryList, Comparator.comparing(CategoryDTO::getRelevancia).reversed());
		
		return null;
	}
	

}
