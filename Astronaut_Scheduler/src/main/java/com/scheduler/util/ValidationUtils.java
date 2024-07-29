/**
 * Utility class for validating task-related data.
 *
 * This class provides methods to validate the description, start time, end time, and priority
 * of a task. It throws a `ValidationException` if any of the provided values are invalid.
 */

package com.scheduler.util;


public class ValidationUtils {
    public static void validateTask(String description, String startTime, String endTime, String priority)
            throws ValidationException {
        if (description == null || description.isEmpty()) {
            throw new ValidationException("Description cannot be null or empty.");
        }
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            throw new ValidationException("Invalid time format. Please Check your time format" );
        }
        if (startTime.compareTo(endTime) >= 0) {
            throw new ValidationException("Start time must be before end time.");
        }
        if (!isValidPriority(priority)) {
            throw new ValidationException("Invalid priority level.");
        }
    }

    private static boolean isValidTimeFormat(String time) {
        return time.matches("([01]\\d|2[0-3]):[0-5]\\d");
    }

    private static boolean isValidPriority(String priority) {
        return priority.equalsIgnoreCase("High") || priority.equalsIgnoreCase("Medium")
                || priority.equalsIgnoreCase("Low");
    }
}
