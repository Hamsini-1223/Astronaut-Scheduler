/**
 * Represents a command to view the tasks managed by the ScheduleManager.
 */

package com.scheduler.command;

import com.scheduler.service.ScheduleManager;

public class ViewTasksCommand implements Command {
    private ScheduleManager scheduleManager;

    public ViewTasksCommand(ScheduleManager scheduleManager) {
        this.scheduleManager = scheduleManager;
    }

    @Override
    public void execute() {
        scheduleManager.viewTasks();
    }
}
