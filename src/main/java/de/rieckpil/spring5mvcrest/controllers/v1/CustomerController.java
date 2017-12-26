package de.rieckpil.spring5mvcrest.controllers.v1;

import de.rieckpil.spring5mvcrest.api.v1.model.CustomerDTO;
import de.rieckpil.spring5mvcrest.api.v1.model.CustomerListDTO;
import de.rieckpil.spring5mvcrest.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers() {
        return new CustomerListDTO(customerService.getAllCustomers());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable("id") String id) {
        return customerService.getCustomerById(Long.valueOf(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createNewCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String id) {
        return customerService.saveCustomerById(customerDTO, Long.valueOf(id));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable("id") String id) {
        return customerService.patchCustomer(customerDTO, Long.valueOf(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") String id) {

        customerService.deleteCustomerById(Long.valueOf(id));
        return;
    }
}
