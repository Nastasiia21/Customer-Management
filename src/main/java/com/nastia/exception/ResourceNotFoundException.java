package com.nastia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for handling scenarios where a requested resource is not found.
 * This could be triggered by looking up a database entity by ID or querying for a resource
 * that does not exist or is not accessible to the requesting user.
 *
 * The @ResponseStatus annotation associates this exception directly with an HTTP 404 Not Found status code.
 * When this exception is thrown from a controller method and propagates to the Spring MVC framework without being caught,
 * Spring automatically sends an HTTP 404 response to the client. This annotation simplifies the process of returning
 * proper HTTP responses for specific error conditions.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND) // Specifies the HTTP status code to return when this exception is thrown.
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with a detailed message.
     * The message typically contains information about the missing resource to aid in debugging or logging.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
     */
    public ResourceNotFoundException(String message) {
        super(message); // Passes the detail message to the superclass constructor.
    }
}
