package com.danielnamur.javarecruitinghsa.services;

import java.util.List;
import java.util.Optional;

import com.danielnamur.javarecruitinghsa.models.CategoryDTO;

public interface CategoryService {
	
    Optional<List<CategoryDTO>> getTopFiveCategories();

    Optional<List<CategoryDTO>> getRemainingCategories();
}