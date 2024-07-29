/**
 * Provides a factory method for creating {@link Task} instances with validation.
 *
 * @param description the description of the task
 * @param startTime the start time of the task
 * @param endTime the end time of the task
 * @param priority the priority of the task
 * @return a new {@link Task} instance with the provided parameters
 * @throws ValidationException if any of the input parameters are invalid
 */

package com.scheduler.model;

import com.scheduler.util.ValidationUtils;
import com.scheduler.util.ValidationException;

public class TaskFactory {
    public static Task createTask(String description, String startTime, String endTime, String priority)
            throws ValidationException {
        ValidationUtils.validateTask(description, startTime, endTime, priority);
        return new Task(description, startTime, endTime, priority);
    }
}
