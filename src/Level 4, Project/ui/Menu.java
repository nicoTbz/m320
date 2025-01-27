package Project.ui;

import Project.logic.Task;
import Project.logic.TaskFactory;
import Project.logic.TaskManager;
import Project.logic.InvalidTaskException;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final TaskManager taskManager = new TaskManager();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Welcome to Task Manager!");

        while (true) {
            System.out.println("\n1. Add Task\n2. View Tasks\n3. Edit Task\n4. Delete Task\n5. Mark Task as Completed\n6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addTask();
                case 2 -> viewTasks();
                case 3 -> editTask();
                case 4 -> deleteTask();
                case 5 -> markTaskAsCompleted();
                case 6 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addTask() {
        boolean typeSelected = false;
        String type = null;
        while (!typeSelected) {
            System.out.print("Enter type \n1. Work\n2. Personal");
            System.out.print("\nChoose an option: ");
            type = scanner.nextLine();
            switch (type) {
                case "1":
                    type = "Work";
                    typeSelected = true;
                    break;
                case "2":
                    type = "Personal";
                    typeSelected = true;
                    break;
                default:
                    System.out.println("Invalid type. Try again.");
                    break;
            }
        }
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter priority (1-5): ");
        int priority = scanner.nextInt();
        System.out.print("Enter due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.next());
        scanner.nextLine(); // Consume newline

        Task task = TaskFactory.createTask(type, title, description, priority, dueDate);
        taskManager.addTask(task);
        System.out.println("Task added successfully!");
    }

    private void viewTasks() {
        String filter = null;
        boolean filterSelected = false;
        while (!filterSelected) {
            System.out.print("Filter by category\n1. Work\n2. Personal\n3. All");
            System.out.print("\nChoose an option: ");
            filter = scanner.nextLine();
            switch (filter) {
                case "1":
                    filter = "Work";
                    filterSelected = true;
                    break;
                case "2":
                    filter = "Personal";
                    filterSelected = true;
                    break;
                case "3":
                    filter = null;
                    filterSelected = true;
                    break;
                default:
                    System.out.println("Invalid filter. Try again.");
                    break;
            }
        }
        
        boolean sortBySelected = false;
        String sortBy = null;
        while (!sortBySelected) {
            System.out.print("Sort by\n 1. priority\n 2. due date");
            System.out.print("\nChoose an option: ");
            sortBy = scanner.nextLine();
            switch (sortBy) {
                case "1":
                    sortBy = "priority";
                    sortBySelected = true;
                    break;
                case "2":
                    sortBy = "dueDate";
                    sortBySelected = true;
                    break;
                default:
                    System.out.println("Invalid sort by. Try again.");
                    break;
            }
        }

        List<Task> tasks = taskManager.getTasks(filter, sortBy);
        tasks.forEach(System.out::println);
    }

    private void editTask() {
        System.out.print("Enter title of the task to edit: ");
        String title = scanner.nextLine();
        System.out.print("Enter new title: ");
        String newTitle = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new priority (1-5): ");
        int priority = scanner.nextInt();
        System.out.print("Enter new due date (YYYY-MM-DD): ");
        LocalDate dueDate = LocalDate.parse(scanner.next());
        scanner.nextLine(); // Consume newline

        try {
            taskManager.updateTask(title, newTitle, description, priority, dueDate);
            System.out.println("Task updated successfully!");
        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteTask() {
        System.out.print("Enter title of the task to delete: ");
        String title = scanner.nextLine();

        try {
            taskManager.removeTask(title);
            System.out.println("Task deleted successfully!");
        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        }
    }

    private void markTaskAsCompleted() {
        System.out.print("Enter title of the task to mark as completed: ");
        String title = scanner.nextLine();

        try {
            taskManager.markTaskAsCompleted(title);
            System.out.println("Task marked as completed!");
        } catch (InvalidTaskException e) {
            System.out.println(e.getMessage());
        }
    }
}
