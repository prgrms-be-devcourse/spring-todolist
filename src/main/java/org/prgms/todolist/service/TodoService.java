package org.prgms.todolist.service;

import org.prgms.todolist.entity.Todo;

import java.util.List;

public interface TodoService {

    Todo.Read createTodo(Todo.Create request);

    Todo.Read readTodo(long id);

    Todo.Read updateTodo(Todo.Update request);

    void deleteTodo(long id);

    List<Todo.Read> readTodos();

    List<Todo.Read> readTodosByStatus(boolean done);
}
