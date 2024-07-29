/**
 * Represents a command that can be executed.
 * Commands are used to encapsulate the logic for performing various actions within the application.
 * Executing a command may throw a {@link com.scheduler.util.ValidationException} if the command's input is invalid.
 */
package com.scheduler.command;

import com.scheduler.util.ValidationException;

public interface Command {
    void execute() throws ValidationException, ValidationException;
}
