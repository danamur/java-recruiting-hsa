package com.danielnamur.javarecruitinghsa.converters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.danielnamur.javarecruitinghsa.models.Category;
import com.danielnamur.javarecruitinghsa.models.CategoryDTO;
import com.danielnamur.javarecruitinghsa.models.Subcategory;

@Component
public class CategoryConverted {

	public List<CategoryDTO> convert(Category value) {

		List<CategoryDTO> result = new ArrayList<>();
		List<Subcategory> subcategories = value.getSubcategories().get(0).getSubcategories();

		for (Subcategory category : subcategories) {
			CategoryDTO categoryDTO = new CategoryDTO();

			if (category.getSubcategories().isEmpty()) {

				categoryDTO.setCategoria(category.getName());
				categoryDTO.setSubcategoria(category.getName());
				categoryDTO.setNombre(category.getName());
				categoryDTO.setRelevancia(category.getRelevance());
				categoryDTO.setImageUrl(category.getIconImageUrl());

			} else {

				categoryDTO.setCategoria(category.getName());
				category = category.getSubcategories().get(0);

				if (category.getSubcategories().isEmpty()) {
					
					categoryDTO.setSubcategoria(category.getName());
					categoryDTO.setNombre(category.getName());
					categoryDTO.setRelevancia(category.getRelevance());
					categoryDTO.setImageUrl(category.getSmallImageUrl());

				} else {
					
					categoryDTO.setSubcategoria(category.getName());
					categoryDTO.setImageUrl(category.getSmallImageUrl());
					category = category.getSubcategories().get(0);
					categoryDTO.setNombre(category.getName());
					categoryDTO.setRelevancia(category.getRelevance());
				}
			}
			
			result.add(categoryDTO);
		}
		
		return result;
	}
}