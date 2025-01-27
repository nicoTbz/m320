package Project.logic;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(String title) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        tasks.remove(task);
    }

    public void updateTask(String title, String newTitle, String description, int priority, LocalDate dueDate) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        task.updateTask(newTitle, description, priority, dueDate);
    }

    public void markTaskAsCompleted(String title) throws InvalidTaskException {
        Task task = findTaskByTitle(title);
        task.setCompleted(true);
    }

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

    private Task findTaskByTitle(String title) throws InvalidTaskException {
        return tasks.stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new InvalidTaskException("Task not found: " + title));
    }
}