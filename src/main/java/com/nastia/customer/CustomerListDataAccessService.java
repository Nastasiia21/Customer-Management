package com.nastia.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A mock data access service for customers, storing data in a static list instead of a database.
 * This implementation is for demonstration or testing purposes.
 */
@Repository("list") // Marks this class as a Spring-managed repository, with "list" as its identifier.
public class CustomerListDataAccessService implements CustomerDAO {

    // Simulated database represented by a static list of customers.
    private static final List<Customer> customers;

    static {
        // Initialize the simulated database.
        customers = new ArrayList<>();

        // Pre-populate the list with some customer entries.
        Customer alex = new Customer(
                1,
                "Alex",
                "alex@gmail.com",
                21
        );
        customers.add(alex);

        Customer jamila = new Customer(
                2,
                "Jamila",
                "jamila@gmail.com",
                19
        );
        customers.add(jamila);
    }

    /**
     * Retrieves all customers from the simulated database.
     * @return A list of all customers.
     */
    @Override
    public List<Customer> selectAllCustomers() {
        return new ArrayList<>(customers);
    }

    /**
     * Searches for a customer by ID.
     * @param id The ID of the customer to find.
     * @return An Optional containing the found customer, if any.
     */
    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    /**
     * Inserts a new customer into the simulated database.
     * @param customer The customer to insert.
     */
    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    /**
     * Checks if a customer with the specified email exists in the simulated database.
     * @param email The email to check.
     * @return True if a customer with the specified email exists, otherwise false.
     */
    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getEmail().equals(email));
    }

    /**
     * Checks if a customer with the specified ID exists in the simulated database.
     * @param id The ID to check.
     * @return True if a customer with the specified ID exists, otherwise false.
     */
    @Override
    public boolean existsPersonWithId(Integer id) {
        return customers.stream()
                .anyMatch(c -> c.getId().equals(id));
    }

    /**
     * Deletes a customer by their ID from the simulated database.
     * @param customerId The ID of the customer to delete.
     */
    @Override
    public void deleteCustomerById(Integer customerId) {
        customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .ifPresent(customers::remove);
    }

    /**
     * Updates the information of an existing customer in the simulated database.
     * Note: This implementation currently adds the customer instead of updating.
     * @param customer The customer with updated information to replace the old customer.
     */
    @Override
    public void updateCustomer(Customer customer) {
        // This method should be implemented to correctly update a customer's details.
        // The current implementation simply adds the customer to the list.
        customers.add(customer);
    }
}
