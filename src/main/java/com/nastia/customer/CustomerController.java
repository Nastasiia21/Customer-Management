package com.nastia.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Controller class for managing customer-related requests.
 * Maps requests to the appropriate service layer methods.
 */
@RestController // Marks this class as a controller where every method returns a domain object instead of a view.
@RequestMapping("api/v1/customers") // Maps HTTP requests to handler methods of MVC and REST controllers.
public class CustomerController {

    private final CustomerService customerService; // Declares a dependency on the CustomerService.

    /**
     * Constructs a CustomerController with a CustomerService.
     * @param customerService The service layer for customer operations, injected by Spring's dependency injection.
     */
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Handles GET requests to retrieve all customers.
     * @return A list of all customers.
     */
    @GetMapping // Maps HTTP GET requests onto specific handler methods.
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    /**
     * Handles GET requests to retrieve a specific customer by their ID.
     * @param customerId The ID of the customer to retrieve.
     * @return The customer with the specified ID.
     */
    @GetMapping("/{customerId}") // Maps HTTP GET requests for a customer's ID onto specific handler methods.
    public Customer getCustomer(@PathVariable("customerId") Integer customerId) {
        return customerService.getCustomer(customerId);
    }

    /**
     * Handles POST requests to register a new customer.
     * @param request The request body containing the new customer's information.
     */
    @PostMapping // Maps HTTP POST requests onto specific handler methods, used to create a new customer.
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        customerService.addCustomer(request);
    }

    /**
     * Handles DELETE requests to remove a customer by their ID.
     * @param customerId The ID of the customer to be deleted.
     */
    @DeleteMapping("{customerId}") // Maps HTTP DELETE requests onto specific handler methods, used to delete a customer.
    public void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        customerService.deleteCustomerById(customerId);
    }

    /**
     * Handles PUT requests to update an existing customer's information.
     * @param customerId The ID of the customer to update.
     * @param updateRequest The request body containing the customer's updated information.
     */
    @PutMapping("{customerId}") // Maps HTTP PUT requests onto specific handler methods, used to update a customer's information.
    public void deleteCustomer(@PathVariable("customerId") Integer customerId,
                               @RequestBody CustomerUpdateRequest updateRequest) {
        customerService.updateCustomer(customerId, updateRequest);
    }
}
