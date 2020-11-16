package com.danielnamur.javarecruitinghsa.repositories;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import com.danielnamur.javarecruitinghsa.models.Category;

@Service
public class CategoryRepository {

    RestTemplateBuilder builder;

    public Category findCategory() {
        String url = "https://cs-hsa-api-categories.herokuapp.com/categories";
        return builder.build().getForEntity(url, Category.class).getBody();
    }
}