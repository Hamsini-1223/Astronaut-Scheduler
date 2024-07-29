package com.scheduler;

import com.scheduler.command.*;
import com.scheduler.model.Task;
import com.scheduler.model.TaskFactory;
import com.scheduler.service.ScheduleManager;
import com.scheduler.util.ValidationException;

import java.util.Scanner;

public class Main {
    
    private static ScheduleManager scheduleManager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        System.out.println("Welcome to Astronaut Task Scheduler!!!");
        Scanner scanner = new Scanner(System.in);

        try {
            boolean running = true;
            while (running) {
                System.out.println("1. Add Task\n2. Remove Task\n3. View Tasks\n4. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addTask(scanner);
                        break;
                    case 2:
                        removeTask(scanner);
                        break;
                    case 3:
                        viewTasks();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting....Thank you for using our product!!!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addTask(Scanner scanner) {
        try {
            System.out.print("Task Description: ");
            String description = scanner.nextLine();
            System.out.print("Start Time (HH:mm): ");
            String startTime = scanner.nextLine();
            System.out.print("End Time (HH:mm): ");
            String endTime = scanner.nextLine();
            System.out.print("Priority (High/Medium/Low): ");
            String priority = scanner.nextLine();

            Task task = TaskFactory.createTask(description, startTime, endTime, priority);
            Command addTask = new AddTaskCommand(scheduleManager, task);
            addTask.execute();
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void removeTask(Scanner scanner) {
        try {
            System.out.print("Task Description to Remove: ");
            String description = scanner.nextLine();

            Command removeTask = new RemoveTaskCommand(scheduleManager, description);
            removeTask.execute();
        } catch (ValidationException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void viewTasks() throws ValidationException {
        Command viewTasks = new ViewTasksCommand(scheduleManager);
        viewTasks.execute();
    }
}
