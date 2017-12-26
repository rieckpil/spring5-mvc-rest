package de.rieckpil.spring5mvcrest.controllers.v1;

import de.rieckpil.spring5mvcrest.api.v1.model.CategoryListDTO;
import de.rieckpil.spring5mvcrest.api.v1.model.CustomerDTO;
import de.rieckpil.spring5mvcrest.api.v1.model.CustomerListDTO;
import de.rieckpil.spring5mvcrest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private  final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers() {
        return new ResponseEntity<>(
                new CustomerListDTO(customerService.getAllCustomers()), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") String id) {
        return new ResponseEntity<>(
               customerService.getCustomerById(Long.valueOf(id)), HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<CustomerDTO>(
                customerService.createNewCustomer(customerDTO), HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.saveCustomerById(customerDTO, Long.valueOf(id)), HttpStatus.OK
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerDTO> patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String id) {
        return new ResponseEntity<CustomerDTO>(
                customerService.patchCustomer(customerDTO, Long.valueOf(id)), HttpStatus.OK
        );
    }
}
