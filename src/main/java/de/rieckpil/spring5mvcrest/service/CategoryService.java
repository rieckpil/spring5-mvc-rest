package de.rieckpil.spring5mvcrest.service;

import de.rieckpil.spring5mvcrest.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
