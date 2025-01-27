package Project.logic;

import java.time.LocalDate;

/**
 * The {@code PersonalTask} class represents a personal task.
 * It extends the {@link Task} class and provides an implementation for the {@code getCategory} method,
 * categorizing the task as "Personal".
 */
public class PersonalTask extends Task {

    /**
     * Constructs a new {@code PersonalTask} with the specified details.
     *
     * @param title       A {@code String} representing the title of the task.
     * @param description A {@code String} providing a description of the task.
     * @param priority    An {@code int} representing the priority level of the task.
     * @param dueDate     A {@link LocalDate} indicating the due date of the task.
     */
    public PersonalTask(String title, String description, int priority, LocalDate dueDate) {
        super(title, description, priority, dueDate);
    }

    /**
     * Returns the category of the task.
     *
     * @return A {@code String} representing the category, which is "Personal".
     */
    @Override
    public String getCategory() {
        return "Personal";
    }
}
