package de.rieckpil.spring5mvcrest.api.v1.mapper;

import de.rieckpil.spring5mvcrest.api.v1.model.CategoryDTO;
import de.rieckpil.spring5mvcrest.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    public static final String NAME = "some name";
    public static final long ID = 1L;

    CategoryMapper cut = CategoryMapper.INSTANCE;

    @Test
    public void testCategoryToCategoryDTO() {

        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        CategoryDTO result = cut.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(ID), result.getId());
        assertEquals(NAME, result.getName());

    }

}