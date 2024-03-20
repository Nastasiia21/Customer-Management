package com.nastia.customer;

import java.util.List;
import java.util.Optional;

/**
 * Interface for data access operations related to customers.
 */
public interface CustomerDAO {

    /**
     * Retrieves all customers from the data store.
     *
     * @return a list of all customers.
     */
    List<Customer> selectAllCustomers();

    /**
     * Retrieves a customer by their ID.
     *
     * @param id the ID of the customer to retrieve.
     * @return an Optional containing the found customer or an empty Optional if no customer is found.
     */
    Optional<Customer> selectCustomerById(Integer id);

    /**
     * Inserts a new customer into the data store.
     *
     * @param customer the customer to insert.
     */
    void insertCustomer(Customer customer);

    /**
     * Checks if a customer exists in the data store with the specified email.
     *
     * @param email the email to check for existence.
     * @return true if a customer with the specified email exists, false otherwise.
     */
    boolean existsPersonWithEmail(String email);

    /**
     * Checks if a customer exists in the data store with the specified ID.
     *
     * @param id the ID to check for existence.
     * @return true if a customer with the specified ID exists, false otherwise.
     */
    boolean existsPersonWithId(Integer id);

    /**
     * Deletes a customer from the data store by their ID.
     *
     * @param customerId the ID of the customer to delete.
     */
    void deleteCustomerById(Integer customerId);

    /**
     * Updates the information of an existing customer in the data store.
     *
     * @param update the customer object containing the updated information.
     */
    void updateCustomer(Customer update);
}
