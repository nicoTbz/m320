package Project.logic;

import java.time.LocalDate;

/**
 * The {@code Task} class is an abstract representation of a task with common properties such as 
 * title, description, priority, due date, and completion status. 
 * It implements the {@link IHasCategory} interface and provides a framework for specialized task types.
 */
public abstract class Task implements IHasCategory {
    private String title;
    private String description;
    private int priority; // 1 (High) to 5 (Low)
    private LocalDate dueDate;
    private boolean isCompleted;

    /**
     * Constructs a new {@code Task} with the specified details.
     *
     * @param title       A {@code String} representing the title of the task.
     * @param description A {@code String} providing a description of the task.
     * @param priority    An {@code int} representing the priority level of the task (1 is high, 5 is low).
     * @param dueDate     A {@link LocalDate} indicating the due date of the task.
     */
    public Task(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    /**
     * Retrieves the title of the task.
     *
     * @return A {@code String} representing the title of the task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the description of the task.
     *
     * @return A {@code String} representing the description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the priority of the task.
     *
     * @return An {@code int} representing the priority level of the task (1 is high, 5 is low).
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Retrieves the due date of the task.
     *
     * @return A {@link LocalDate} representing the due date of the task.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Checks if the task is completed.
     *
     * @return {@code true} if the task is completed; {@code false} otherwise.
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Updates the completion status of the task.
     *
     * @param completed {@code true} to mark the task as completed, {@code false} otherwise.
     */
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    /**
     * Updates the task details, including title, description, priority, and due date.
     *
     * @param title       A {@code String} representing the updated title of the task.
     * @param description A {@code String} representing the updated description of the task.
     * @param priority    An {@code int} representing the updated priority level of the task.
     * @param dueDate     A {@link LocalDate} representing the updated due date of the task.
     */
    public void updateTask(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    /**
     * Retrieves the category of the task. 
     * This method should be implemented by subclasses to define their specific category.
     *
     * @return A {@code String} representing the category of the task, or {@code null} by default.
     */
    public String getCategory() {
        return null;
    }

    /**
     * Returns a string representation of the task, including its category, title, priority, due date, and completion status.
     *
     * @return A {@code String} describing the task in a readable format.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s (Priority: %d, Due: %s, Completed: %b)",
                getCategory(), title, priority, dueDate, isCompleted);
    }
}
