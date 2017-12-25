package de.rieckpil.spring5mvcrest.api.v1.mapper;

import de.rieckpil.spring5mvcrest.api.v1.model.CategoryDTO;
import de.rieckpil.spring5mvcrest.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryMapperTest {

    CategoryMapper cut = CategoryMapper.INSTANCE;

    @Test
    public void testCategoryToCategoryDTO() {

        Category category = new Category();
        category.setName("some name");
        category.setId(1L);

        CategoryDTO result = cut.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(1l), result.getId());
        assertEquals("some name", result.getName());

    }

}