package Project.logic;

import java.time.LocalDate;

public class TaskFactory {
    public static Task createTask(String type, String title, String description, int priority, LocalDate dueDate) {
        return switch (type.toLowerCase()) {
            case "work" -> new WorkTask(title, description, priority, dueDate);
            case "personal" -> new PersonalTask(title, description, priority, dueDate);
            default -> throw new IllegalArgumentException("Invalid task type: " + type);
        };
    }
}
