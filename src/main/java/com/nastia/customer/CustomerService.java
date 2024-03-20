package com.nastia.customer;

import com.nastia.exception.DuplicateResourceException;
import com.nastia.exception.RequestValidationException;
import com.nastia.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer class that handles business logic for customer operations.
 * This class uses a CustomerDAO for database operations.
 */
@Service // Marks this class as a Spring service stereotype.
public class CustomerService {

    private final CustomerDAO customerDAO;

    /**
     * Constructs the service with a specific implementation of CustomerDAO.
     * The @Qualifier annotation is used to specify which bean to inject when multiple beans of the same type are present.
     *
     * @param customerDAO The data access object for customer operations.
     */
    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    /**
     * Retrieves all customers from the database.
     *
     * @return A list of all customers.
     */
    public List<Customer> getAllCustomers() {
        return customerDAO.selectAllCustomers();
    }

    /**
     * Retrieves a specific customer by ID.
     * Throws a ResourceNotFoundException if the customer is not found.
     *
     * @param id The ID of the customer to retrieve.
     * @return The retrieved customer.
     */
    public Customer getCustomer(Integer id) {
        return customerDAO.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "customer with id [%s] not found".formatted(id)
                ));
    }

    /**
     * Adds a new customer based on the provided registration request.
     * Throws DuplicateResourceException if the email is already taken.
     *
     * @param customerRegistrationRequest The registration request containing the customer's information.
     */
    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        String email = customerRegistrationRequest.email();
        if (customerDAO.existsPersonWithEmail(email)) {
            throw new DuplicateResourceException("email already taken");
        }
        customerDAO.insertCustomer(
                new Customer(
                        customerRegistrationRequest.name(),
                        customerRegistrationRequest.email(),
                        customerRegistrationRequest.age()
                )
        );
    }

    /**
     * Deletes a customer by their ID.
     * Throws ResourceNotFoundException if the customer does not exist.
     *
     * @param customerId The ID of the customer to delete.
     */
    public void deleteCustomerById(Integer customerId) {
        if (!customerDAO.existsPersonWithId(customerId)) {
            throw new ResourceNotFoundException("customer with id [%s] not found".formatted(customerId));
        }
        customerDAO.deleteCustomerById(customerId);
    }

    /**
     * Updates the information of an existing customer.
     * Validates changes and ensures the new email (if changed) is not already taken.
     * Throws RequestValidationException if no changes are detected.
     *
     * @param customerId     The ID of the customer to update.
     * @param updateRequest The request containing the updated customer information.
     */
    public void updateCustomer(Integer customerId, CustomerUpdateRequest updateRequest) {
        Customer customer = getCustomer(customerId);

        boolean changes = false;

        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changes = true;
        }

        if (updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            changes = true;
        }

        if (updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            if (customerDAO.existsPersonWithEmail(updateRequest.email())) {
                throw new DuplicateResourceException("email already taken");
            }
            customer.setEmail(updateRequest.email());
            changes = true;
        }

        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerDAO.updateCustomer(customer);
    }
}

