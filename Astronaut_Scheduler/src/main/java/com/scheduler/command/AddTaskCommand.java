/**
 * Represents a command to add a new task to the schedule manager.
 * The AddTaskCommand encapsulates the logic to add a task to the schedule manager.
 */

package com.scheduler.command;

import com.scheduler.model.Task;
import com.scheduler.service.ScheduleManager;
import com.scheduler.util.ValidationException;

public class AddTaskCommand implements Command {
    private ScheduleManager scheduleManager;
    private Task task;

    public AddTaskCommand(ScheduleManager scheduleManager, Task task) {
        this.scheduleManager = scheduleManager;
        this.task = task;
    }

    @Override
    public void execute() throws ValidationException {
        scheduleManager.addTask(task);
    }
}
