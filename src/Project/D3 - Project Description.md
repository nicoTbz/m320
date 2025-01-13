### **Task Manager (To-Do List App)**

**Project Description:**  
The Task Manager is a console-based application designed to help users efficiently manage their daily tasks. Users can create, edit, delete, and mark tasks as completed. Each task can be categorized (e.g., Work, Personal) and assigned a priority level and due date. The task list can be filtered and sorted by priority, due date, or completion status.

The application's architecture is clearly separated into user interface (UI) and business logic. Using the **Factory Design Pattern**, different types of tasks (e.g., work tasks, personal tasks) can be created flexibly. Custom exception classes handle invalid user input, such as empty task descriptions or incorrect dates.

**Features:**
- **Add Tasks:** Create new tasks with a title, description, priority, and due date.
- **View Tasks:** Filter and sort tasks by status, priority, and due date.
- **Edit Tasks:** Update existing tasks.
- **Delete Tasks:** Remove tasks from the list.
- **Change Task Status:** Mark tasks as completed or pending.

**Technical Implementation:**
- **Delegation:** Clear separation of UI and business logic.
- **Custom Exceptions:** `InvalidTaskException` for invalid inputs.
- **Polymorphism:** Abstract `Task` class with subclasses `WorkTask` and `PersonalTask`.
- **Design Pattern:** **Factory Pattern** for creating different task types.
- **Clean Code:** Well-structured code with descriptive names and comments.  