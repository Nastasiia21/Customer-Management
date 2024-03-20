package com.nastia.customer;

/**
 * A record for encapsulating update request data for a customer.
 * This record is used to carry data from the client to the service layer for updating a customer's details.
 *
 * Records provide a concise syntax for declaring classes which are immutable and meant primarily
 * to encapsulate data. They automatically generate public getters, equals(), hashCode(), and toString() methods.
 */
public record CustomerUpdateRequest(
        // The new name of the customer. Can be null if the name is not being updated.
        String name,
        // The new email of the customer. Can be null if the email is not being updated.
        String email,
        // The new age of the customer. Can be null if the age is not being updated.
        Integer age
) {
    // The body of the record can include additional methods or custom constructors if needed,
    // but it's not necessary for simple data carriers like this one.
}
