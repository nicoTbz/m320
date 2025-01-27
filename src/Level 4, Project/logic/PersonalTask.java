package Project.logic;

import java.time.LocalDate;

public class PersonalTask extends Task {
    public PersonalTask(String title, String description, int priority, LocalDate dueDate) {
        super(title, description, priority, dueDate);
    }

    public String getCategory() {
        return "Personal";
    }
}
