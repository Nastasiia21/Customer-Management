package com.nastia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Custom exception class for handling duplicate resource situations in the application.
 * This exception is thrown when an operation attempts to create or update a resource
 * in a way that would violate uniqueness constraints (e.g., trying to register a user
 * with an email that already exists in the database).
 *
 * The @ResponseStatus annotation marks this exception class to automatically trigger
 * an HTTP 409 Conflict response when the exception is thrown and uncaught in a controller
 * method. This provides a clear and RESTful way to inform the client about the nature
 * of the error.
 */
@ResponseStatus(code = HttpStatus.CONFLICT) // Specifies the HTTP status code to return when this exception is thrown.
public class DuplicateResourceException extends RuntimeException {
    /**
     * Constructs a new DuplicateResourceException with the specified detail message.
     * The message typically contains a description of the duplicate resource error.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
     */
    public DuplicateResourceException(String message) {
        super(message);
    }
}
