/**
 * Represents a command to remove a task from the schedule.
 * 
 * @param scheduleManager the ScheduleManager instance used to remove the task
 * @param taskDescription the description of the task to be removed
 */

package com.scheduler.command;

import com.scheduler.service.ScheduleManager;
import com.scheduler.util.ValidationException;

public class RemoveTaskCommand implements Command {
    private ScheduleManager scheduleManager;
    private String taskDescription;

    public RemoveTaskCommand(ScheduleManager scheduleManager, String taskDescription) {
        this.scheduleManager = scheduleManager;
        this.taskDescription = taskDescription;
    }

    @Override
    public void execute() throws ValidationException {
        scheduleManager.removeTask(taskDescription);
    }
}
