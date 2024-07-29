/**
 * Manages a schedule of tasks, allowing tasks to be added, removed, and viewed.
 * The schedule ensures that tasks do not overlap in time.
 */
package com.scheduler.service;

import com.scheduler.model.Task;
import com.scheduler.util.ValidationException;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class Schedule {
    private final List<Task> tasks;

    public Schedule() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) throws ValidationException {
        for (Task t : tasks) {
            if (isOverlapping(t, task)) {
                throw new ValidationException("Task conflicts with existing task: " + t.getDescription());
            }
        }
        tasks.add(task);
        sortTasks();
    }

    public void removeTask(String description) throws ValidationException {
        Task taskToRemove = null;
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                taskToRemove = task;
                break;
            }
        }
        if (taskToRemove == null) {
            throw new ValidationException("Task not found: " + description);
        }
        tasks.remove(taskToRemove);
    }

    public List<Task> viewTasks() {
        return new ArrayList<>(tasks);
    }

    private void sortTasks() {
        tasks.sort(Comparator.comparing(Task::getStartTime));
    }

    private boolean isOverlapping(Task t1, Task t2) {
        return (t1.getStartTime().compareTo(t2.getEndTime()) < 0) && (t2.getStartTime().compareTo(t1.getEndTime()) < 0);
    }
}
