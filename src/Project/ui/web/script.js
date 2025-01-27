const TodoApp = (() => {
  let todos = [];

  const addTodo = (event) => {
      event.preventDefault();
      const todoInput = document.getElementById('todo-input');
      const prioritySelect = document.getElementById('priority-select');
      const dateInput = document.getElementById('date-input');
      const todo = {
          id: Date.now(),
          text: todoInput.value.trim(),
          priority: prioritySelect.value,
          date: dateInput.value
      };

      todos.push(todo);
      todoInput.value = '';
      dateInput.value = '';
      renderTodos();
  };

  // Löschen einer Aufgabe
  const deleteTodo = (id) => {
      todos = todos.filter(todo => todo.id !== id);
      renderTodos();
  };

  // Darstellung der Aufgaben
  const renderTodos = () => {
      const todoList = document.getElementById('todo-list');
      todoList.innerHTML = '';

      todos.forEach(todo => {
          const li = document.createElement('li');
          li.classList.add(todo.priority);
          li.innerHTML = `
              <span>${todo.text} (Priorität: ${capitalize(todo.priority)}, Datum: ${todo.date})</span>
              <button class="delete-btn" onclick="TodoApp.deleteTodo(${todo.id})">Löschen</button>
          `;
          todoList.appendChild(li);
      });
  };

  const sortByPriority = () => {
      const priorityOrder = { hoch: 1, mittel: 2, niedrig: 3 };
      todos.sort((a, b) => priorityOrder[a.priority] - priorityOrder[b.priority]);
      renderTodos();
  };

  const sortByDate = () => {
      todos.sort((a, b) => new Date(a.date) - new Date(b.date));
      renderTodos();
  };

  const capitalize = (str) => str.charAt(0).toUpperCase() + str.slice(1);

  const init = () => {
      document.getElementById('todo-form').addEventListener('submit', addTodo);
      document.getElementById('sort-priority').addEventListener('click', sortByPriority);
      document.getElementById('sort-date').addEventListener('click', sortByDate);
  };

  return { init, deleteTodo };
})();

// App initialisieren
document.addEventListener('DOMContentLoaded', TodoApp.init);
