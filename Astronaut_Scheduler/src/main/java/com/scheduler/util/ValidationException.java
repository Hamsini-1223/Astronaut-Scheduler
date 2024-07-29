/**
 * Represents an exception that occurs during validation of input data.
 * This exception is used to log errors and provide a descriptive error message.
 */

package com.scheduler.util;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
        Logger.logError(message);
    }
}
