package de.rieckpil.spring5mvcrest.bootstrap;

import de.rieckpil.spring5mvcrest.domain.Category;
import de.rieckpil.spring5mvcrest.domain.Customer;
import de.rieckpil.spring5mvcrest.repositories.CategoryRepository;
import de.rieckpil.spring5mvcrest.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Initial data is loading ...");
        loadCategories();
        loadCustomers();
        log.info("... Initial data is loaded.");

    }

    public void loadCategories() {

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


    }

    private void loadCustomers() {

        Customer customer1 = new Customer();
        customer1.setFirstName("Philip");
        customer1.setLastName("Riecks");

        Customer customer2 = new Customer();
        customer2.setFirstName("Max");
        customer2.setLastName("Mustermann");

        Customer customer3 = new Customer();
        customer3.setFirstName("Maxime");
        customer3.setLastName("Musterfrau");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
    }
}
