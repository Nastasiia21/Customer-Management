package com.nastia.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Data access service for Customer entities using JPA.
 */
@Repository("jpa") // Marks this class as a Data Access Object (Repository) that uses JPA for data operations.
public class CustomerJPADataAccessService implements CustomerDAO {

    private final CustomerRepository customerRepository; // Spring Data JPA repository for Customer entities.

    /**
     * Constructs a CustomerJPADataAccessService with a CustomerRepository.
     *
     * @param customerRepository Spring Data JPA repository for Customer entities.
     */
    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return A List of all Customer entities.
     */
    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Retrieves a customer by their ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return An Optional containing the found customer or an empty Optional if no customer is found.
     */
    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    /**
     * Inserts a new customer into the database.
     *
     * @param customer The customer to insert.
     */
    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    /**
     * Checks if a customer exists in the database with the specified email.
     *
     * @param email The email to check for existence.
     * @return True if a customer with the specified email exists, false otherwise.
     */
    @Override
    public boolean existsPersonWithEmail(String email) {
        return customerRepository.existsCustomersByEmail(email);
    }

    /**
     * Checks if a customer exists in the database with the specified ID.
     *
     * @param id The ID to check for existence.
     * @return True if a customer with the specified ID exists, false otherwise.
     */
    @Override
    public boolean existsPersonWithId(Integer id) {
        return customerRepository.existsCustomerById(id);
    }

    /**
     * Deletes a customer from the database by their ID.
     *
     * @param customerId The ID of the customer to delete.
     */
    @Override
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    /**
     * Updates the information of an existing customer in the database.
     *
     * @param update The customer object containing the updated information.
     */
    @Override
    public void updateCustomer(Customer update) {
        customerRepository.save(update);
    }
}

