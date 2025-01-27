package Project.logic;

import java.time.LocalDate;

public abstract class Task implements IHasCategory {
    private String title;
    private String description;
    private int priority; // 1 (High) to 5 (Low)
    private LocalDate dueDate;
    private boolean isCompleted;

    public Task(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void updateTask(String title, String description, int priority, LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public String getCategory(){
       return null; 
    };

    @Override
    public String toString() {
        return String.format("[%s] %s (Priority: %d, Due: %s, Completed: %b)",
                getCategory(), title, priority, dueDate, isCompleted);
    }
}
