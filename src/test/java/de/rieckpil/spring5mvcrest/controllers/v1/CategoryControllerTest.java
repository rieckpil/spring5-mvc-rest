package de.rieckpil.spring5mvcrest.controllers.v1;

import de.rieckpil.spring5mvcrest.api.v1.model.CategoryDTO;
import de.rieckpil.spring5mvcrest.service.CategoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService mockedCategoryService;

    @InjectMocks
    private CategoryController cut;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cut).build();
    }

    @Test
    public void testGetAllCategories() throws Exception{

        CategoryDTO category1 = new CategoryDTO();
        category1.setId(1L);
        category1.setName("Nuts");

        CategoryDTO category2 = new CategoryDTO();
        category2.setId(2L);
        category2.setName("Fruits");

        List<CategoryDTO> categories = Arrays.asList(category1, category2);

        when(mockedCategoryService.getAllCategories()).thenReturn(categories);

        mockMvc.perform(get("/api/v1/categories/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.categories", hasSize(2)));

    }

}