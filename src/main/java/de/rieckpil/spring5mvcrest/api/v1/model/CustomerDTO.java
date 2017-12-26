package de.rieckpil.spring5mvcrest.api.v1.model;

import lombok.Data;

@Data
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String customerUrl;

}
