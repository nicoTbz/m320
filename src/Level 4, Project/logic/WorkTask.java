package Project.logic;

import java.time.LocalDate;

public class WorkTask extends Task {
    public WorkTask(String title, String description, int priority, LocalDate dueDate) {
        super(title, description, priority, dueDate);
    }

    public String getCategory() {
        return "Work";
    }
}
