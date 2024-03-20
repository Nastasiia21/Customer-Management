package com.nastia.customer;

/**
 * A record representing a request to register a new customer.
 * Records in Java are a special kind of class; they are immutable and meant to serve primarily as data carriers.
 * They automatically generate equals(), hashCode(), and toString() methods, as well as public getters for all fields.
 *
 * This record is used to encapsulate the data needed when a new customer registration request is made.
 */
public record CustomerRegistrationRequest(
        // The name of the customer being registered.
        String name,
        // The email of the customer. This should be unique across all customers.
        String email,
        // The age of the customer. Depending on the application's requirements, there could be validation rules.
        Integer age
) {
    // Since this is a record, there's no need to manually define constructors, getters, or standard methods like equals(),
    // hashCode(), and toString(). All of these are provided automatically based on the components of the record.
}
