package de.rieckpil.spring5mvcrest.repositories;

import de.rieckpil.spring5mvcrest.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="/products")
public interface ProductRepository extends CrudRepository<Product, Long> {
}
