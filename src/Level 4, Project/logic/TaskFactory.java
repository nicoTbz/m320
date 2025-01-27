package Project.logic;

import java.time.LocalDate;

/**
 * The {@code TaskFactory} class provides a factory method for creating different types of tasks.
 * It uses the {@code createTask} method to generate a task instance based on the specified type.
 */
public class TaskFactory {

    /**
     * Creates a new task based on the specified type.
     *
     * @param type        A {@code String} representing the type of the task (e.g., "work" or "personal").
     * @param title       A {@code String} representing the title of the task.
     * @param description A {@code String} providing a description of the task.
     * @param priority    An {@code int} representing the priority level of the task (1 is high, 5 is low).
     * @param dueDate     A {@link LocalDate} indicating the due date of the task.
     * @return A {@link Task} object corresponding to the specified type.
     * @throws IllegalArgumentException if the specified type is invalid.
     */
    public static Task createTask(String type, String title, String description, int priority, LocalDate dueDate) {
        return switch (type.toLowerCase()) {
            case "work" -> new WorkTask(title, description, priority, dueDate);
            case "personal" -> new PersonalTask(title, description, priority, dueDate);
            default -> throw new IllegalArgumentException("Invalid task type: " + type);
        };
    }
}
