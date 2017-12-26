package de.rieckpil.spring5mvcrest.repositories;

import de.rieckpil.spring5mvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
