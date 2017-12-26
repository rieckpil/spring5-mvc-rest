package de.rieckpil.spring5mvcrest.service;

import de.rieckpil.spring5mvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerById(CustomerDTO customerDTO, Long id);

    CustomerDTO patchCustomer(CustomerDTO customerDTO, Long id);

    void deleteCustomerById(Long id);
}
