/**
 * The `ScheduleManager` class in the `com.scheduler.service` package manages tasks, allowing users to
 * add, remove, and view tasks while handling notifications and logging.
 */

package com.scheduler.service;

import com.scheduler.model.Task;
import com.scheduler.util.Logger;
import com.scheduler.util.ValidationException;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final Schedule schedule;
    private UserNotifier userNotifier;


    private ScheduleManager() {
        this.schedule = new Schedule();
        userNotifier = new UserNotifier();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(Task task) throws ValidationException {
        try {
            schedule.addTask(task);
            userNotifier.addNotification("Task added successfully. No conflicts.");
            Logger.logInfo("Task added: " + task.getDescription());
        } catch (ValidationException e) {
            userNotifier.addNotification(e.getMessage());
        } finally {
            userNotifier.notifyUsers();
        }
        
    }

    public void removeTask(String description) throws ValidationException {
        try {
            if (schedule.viewTasks().size() == 0) {
                userNotifier.addNotification("No Tasks to remove! Please add task to continue ");
                return;
            }
            schedule.removeTask(description);
            userNotifier.addNotification("Task removed successfully.");
            Logger.logInfo("Task removed: " + description);
        } catch (ValidationException e) {
            userNotifier.addNotification(e.getMessage());
        } finally {
            userNotifier.notifyUsers();
        }
        
    }
    
    public void viewTasks() {
        if(schedule.viewTasks().size()>=1){
            schedule.viewTasks().forEach(task -> System.out.println(task.getStartTime() + " - " + task.getEndTime()
                    + ": " + task.getDescription() + " [" + task.getPriority() + "]"));
            Logger.logInfo("Viewed tasks");
            
        }
        else{
            userNotifier.addNotification("No tasks has been scheduled today!");
        }
        userNotifier.notifyUsers();
    }
}
