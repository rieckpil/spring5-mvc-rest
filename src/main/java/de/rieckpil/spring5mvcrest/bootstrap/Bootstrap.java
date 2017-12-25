package de.rieckpil.spring5mvcrest.bootstrap;

import de.rieckpil.spring5mvcrest.domain.Category;
import de.rieckpil.spring5mvcrest.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;

    public Bootstrap(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Initial data is loading ...");

        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fresh);
        categoryRepository.save(dried);
        categoryRepository.save(fruits);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        log.info("... Initial data is loaded.");

    }
}
