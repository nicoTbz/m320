sequenceDiagram
  actor User
  participant Main
  participant Menu
  participant TaskManager
  participant TaskFactory
  participant Task

  User->>Main: Start application
  Main->>Menu: Create Menu instance<br/>and call start()
  User->>Menu: Select "Add Task"
  Menu->>User: Prompt for task details
  User-->>Menu: Provide type, title,<br/>description, priority, and due date
  Menu->>TaskFactory: Call createTask(type, title, description,<br/>priority, dueDate)
  TaskFactory-->>Menu: Return Task instance
  Menu->>TaskManager: Call addTask(task)
  TaskManager-->>Menu: Confirm task addition
  Menu-->>User: Display success message