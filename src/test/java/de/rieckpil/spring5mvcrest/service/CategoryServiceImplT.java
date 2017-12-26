package de.rieckpil.spring5mvcrest.service;

import de.rieckpil.spring5mvcrest.api.v1.mapper.CustomerMapper;
import de.rieckpil.spring5mvcrest.api.v1.model.CustomerDTO;
import de.rieckpil.spring5mvcrest.bootstrap.Bootstrap;
import de.rieckpil.spring5mvcrest.domain.Customer;
import de.rieckpil.spring5mvcrest.repositories.CategoryRepository;
import de.rieckpil.spring5mvcrest.repositories.CustomerRepository;
import de.rieckpil.spring5mvcrest.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryServiceImplT {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Loading Customer data");
        System.out.println(customerRepository.findAll().size());

        Bootstrap bootstrap = new Bootstrap(categoryRepository, customerRepository, productRepository);
        bootstrap.run();

        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void patchCustomerUpdateFirstName() throws Exception {

        String updateFirstName = "UpdateNameValue";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalLastName = originalCustomer.getLastName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName(updateFirstName);

        customerService.patchCustomer(customerDTO, id);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updateFirstName, updatedCustomer.getFirstName());
        assertEquals(originalLastName, updatedCustomer.getLastName());


    }

    @Test
    public void patchCustomerUpdateLastName() throws Exception {

        String updateLastName = "UpdateNameValue";
        long id = getCustomerIdValue();

        Customer originalCustomer = customerRepository.getOne(id);
        assertNotNull(originalCustomer);

        String originalFirstName = originalCustomer.getFirstName();

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName(updateLastName);

        customerService.patchCustomer(customerDTO, id);

        Customer updatedCustomer = customerRepository.findById(id).get();

        assertNotNull(updatedCustomer);
        assertEquals(updateLastName, updatedCustomer.getLastName());
        assertEquals(originalFirstName, updatedCustomer.getFirstName());

    }

    private Long getCustomerIdValue() {
        List<Customer> customers = customerRepository.findAll();

        System.out.println("Customers found: " + customers.size());

        return customers.get(0).getId();
    }

}