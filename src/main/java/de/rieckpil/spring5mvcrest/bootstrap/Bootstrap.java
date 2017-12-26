package de.rieckpil.spring5mvcrest.bootstrap;

import de.rieckpil.spring5mvcrest.domain.Category;
import de.rieckpil.spring5mvcrest.domain.Customer;
import de.rieckpil.spring5mvcrest.domain.Product;
import de.rieckpil.spring5mvcrest.repositories.CategoryRepository;
import de.rieckpil.spring5mvcrest.repositories.CustomerRepository;
import de.rieckpil.spring5mvcrest.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private ProductRepository productRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("Initial data is loading ...");
        loadCategories();
        loadCustomers();
        loadProducts();
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

    private void loadProducts() {

        Product product1 = new Product();
        product1.setCategory("Toys");
        product1.setProductName("Lego Technic");

        Product product2 = new Product();
        product2.setCategory("Utility");
        product2.setProductName("Teeth Brusher");

        Product product3 = new Product();
        product3.setCategory("Equipment");
        product3.setProductName("Hat");

        Product product4 = new Product();
        product4.setCategory("Movie");
        product4.setProductName("The Gladiator");

        Product product5 = new Product();
        product5.setCategory("Shoe");
        product5.setProductName("Yezzy Boost");

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);

    }
}
