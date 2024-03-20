package com.nastia.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Customer entities. This interface is used for data access operations on Customer data.
 * It extends JpaRepository, which provides JPA related methods for standard data access operations.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // Inherits standard CRUD operations and query methods from JpaRepository.

    /**
     * Checks if a customer with the given email exists in the database.
     *
     * @param email The email to check for existence.
     * @return true if a customer with the specified email exists, false otherwise.
     */
    boolean existsCustomersByEmail(String email);

    /**
     * Checks if a customer with the given ID exists in the database.
     *
     * @param id The ID to check for existence.
     * @return true if a customer with the specified ID exists, false otherwise.
     */
    boolean existsCustomerById(Integer id);

    // Additional custom queries and operations can be defined here.
}
