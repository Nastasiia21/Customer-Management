package com.nastia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Custom exception class to signal validation errors in incoming requests.
 * When thrown, it indicates that a client's request did not pass validation checks,
 * typically due to missing or invalid data in the request body or parameters.
 *
 * The @ResponseStatus annotation is used to automatically convert this exception into
 * an HTTP response with a 400 Bad Request status code when the exception is thrown and not caught
 * within a Spring MVC controller. This provides a RESTful way to communicate the nature of the error
 * back to the client, helping clients understand that the error resulted from the data they submitted.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST) // Marks this exception to result in a HTTP 400 Bad Request response.
public class RequestValidationException extends RuntimeException {
    /**
     * Constructs a new RequestValidationException with a specific detail message.
     * The message is meant to convey more detailed information about the nature of the validation error.
     *
     * @param message The detail message associated with the exception. The message is saved for later retrieval
     *                by the Throwable.getMessage() method.
     */
    public RequestValidationException(String message) {
        super(message); // Passes the detail message to the RuntimeException constructor.
    }
}
