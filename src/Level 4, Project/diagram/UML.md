classDiagram

class Main {
  +main(args: String[])
}

class Menu {
  +start()
  -addTask()
  -viewTasks()
  -editTask()
  -deleteTask()
  -markTaskAsCompleted()
}

class TaskManager {
  +addTask(task: Task)
  +removeTask(title: String)
  +updateTask(title: String, newTitle: String, description: String, priority: int, dueDate: LocalDate)
  +markTaskAsCompleted(title: String)
  +getTasks(filter: String, sortBy: String): List<Task>
}

class Task {
  -title: String
  -description: String
  -priority: int
  -dueDate: LocalDate
  -isCompleted: boolean
  +getTitle(): String
  +getDescription(): String
  +getPriority(): int
  +getDueDate(): LocalDate
  +isCompleted(): boolean
  +setCompleted(completed: boolean)
  +updateTask(title: String, description: String, priority: int, dueDate: LocalDate)
  +getCategory(): String
}

class WorkTask {
  +getCategory(): String
}

class PersonalTask {
  +getCategory(): String
}

class TaskFactory {
  +createTask(type: String, title: String, description: String, priority: int, dueDate: LocalDate): Task
}

class InvalidTaskException {
  +InvalidTaskException(message: String)
}

class IHasCategory {
  +getCategory(): String
}

Main --> Menu
Menu --> TaskManager
TaskManager --> Task
Task <|-- WorkTask
Task <|-- PersonalTask
TaskFactory --> Task
TaskManager --> InvalidTaskException
TaskManager --> IHasCategory