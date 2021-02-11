package org.example.model.user;

import lombok.Data;

@Data
public class Address {

    private String street;

    private String suite;

    private String city;

    private String zipcode;

    private GeographicalCoordinates geo;
}
