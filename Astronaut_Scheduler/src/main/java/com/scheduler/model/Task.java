/**
 * Represents a task with a description, start time, end time, and priority.
 * The task can be displayed as a string in the format "startTime - endTime: description [priority]".
 */
package com.scheduler.model;

public class Task {
    private String description;
    private String startTime;
    private String endTime;
    private String priority;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]";
    }
}
