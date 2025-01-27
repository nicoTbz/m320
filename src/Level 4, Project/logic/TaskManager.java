package Project.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code TaskManager} class is responsible for managing a collection of tasks.
 * It provides functionality for adding, removing, updating, filtering, and sorting tasks.
 */
public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Adds a new task to the task manager.
     *
     * @param task A {@link Task} to be added to the task manager.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task with the specified title from the task manager.
     *
     * @param title A {@code String} representing the title of the task to be removed.
     * @throws InvalidTaskException if no task with the specified title is found.
     */
    public void removeTask(String title) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        tasks.remove(task);
    }

    /**
     * Updates the details of a task with the specified title.
     *
     * @param title       A {@code String} representing the title of the task to be updated.
     * @param newTitle    A {@code String} representing the new title for the task.
     * @param description A {@code String} representing the updated description of the task.
     * @param priority    An {@code int} representing the updated priority level of the task.
     * @param dueDate     A {@link LocalDate} representing the updated due date of the task.
     * @throws InvalidTaskException if no task with the specified title is found.
     */
    public void updateTask(String title, String newTitle, String description, int priority, LocalDate dueDate) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        task.updateTask(newTitle, description, priority, dueDate);
    }

    /**
     * Marks a task with the specified title as completed.
     *
     * @param title A {@code String} representing the title of the task to mark as completed.
     * @throws InvalidTaskException if no task with the specified title is found.
     */
    public void markTaskAsCompleted(String title) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        task.setCompleted(true);
    }

    /**
     * Retrieves a list of tasks based on the specified filter and sorting criteria.
     *
     * @param filter A {@code String} representing the category to filter tasks by (e.g., "work", "personal").
     *               If {@code null}, no filtering is applied.
     * @param sortBy A {@code String} representing the sorting criterion ("priority" or "dueDate").
     * @return A {@code List<Task>} of tasks that match the filter and sorting criteria.
     */
    public List<Task> getTasks(String filter, String sortBy) {
        return tasks.stream()
                .filter(task -> filter == null || task.getCategory().equalsIgnoreCase(filter))
                .sorted((t1, t2) -> {
                    if ("priority".equalsIgnoreCase(sortBy)) {
                        return Integer.compare(t1.getPriority(), t2.getPriority());
                    } else if ("dueDate".equalsIgnoreCase(sortBy)) {
                        return t1.getDueDate().compareTo(t2.getDueDate());
                    }
                    return 0;
                })
                .collect(Collectors.toList());
    }

    /**
     * Finds a task by its title.
     *
     * @param title A {@code String} representing the title of the task to find.
     * @return The {@link Task} with the specified title.
     * @throws InvalidTaskException if no task with the specified title is found.
     */
    private Task findTaskByTitle(String title) throws InvalidTaskException {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new InvalidTaskException("Task not found: " + title));
    }
}
