# Astronaut Scheduler

## Overview
The Astronaut Scheduler is a console-based application that helps astronauts organize their daily schedules. It allows users to add, remove, and view daily tasks. Each task has a description, start time, end time, and priority level. The application ensures that tasks do not overlap and provides appropriate error messages for invalid operations.

## Features
- **Add a Task**: Create a new task with a description, start time, end time, and priority level.
- **Remove a Task**: Remove an existing task by its description.
- **View Tasks**: View all tasks sorted by start time.
- **Task Validation**: Ensure no overlapping tasks are added.
- **Logging**: Tracks application usage and errors.
- **Graceful Error Handling**: Proper handling of errors and edge cases.

## Design Patterns Used
- **Singleton Pattern**: Ensures only one instance of `ScheduleManager`.
- **Factory Pattern**: Used for creating `Task` objects.
- **Command Pattern**: Encapsulates all actions as command objects.

## Installation
1. Clone the repository:
    ```bash
    git clone <repository_url>
    ```
2. Navigate to the project directory:
    ```bash
    cd Astronaut_Scheduler/src/main/java
    ```
3. Compile the project:
    ```bash
    javac -source 1.8 -target 1.8 -d bin com/scheduler/*.java  
    ```
4. Run the application:
    ```bash
    java -cp bin com.scheduler.Main 
    ```

## Usage
1. Start the application.
2. you can add, remove, or view tasks.
3. Follow the prompts to manage your schedule.

## Logging
All application logs are stored in `scheduler.log`. This includes information logs for actions taken and error logs for any issues encountered.

## Example Commands
- **Add Task**:
  Enter task description: Morning Exercise
  Enter start time (HH:MM): 07:00
  Enter end time (HH:MM): 08:00
  Enter priority (High/Medium/Low): High
- **Remove Task**:
  Enter task description to remove: Morning Exercise

## Error Handling
- Task conflicts are checked before adding a new task.
- Invalid time formats and priority levels are validated.
- Appropriate error messages are displayed for all invalid operations.

## Code Quality
- Adheres to SOLID principles and object-oriented programming best practices.
- Well-organized code with each class in a separate file.
- Extensive logging and error handling for robust performance.

## License
This project is licensed under the MIT License.


