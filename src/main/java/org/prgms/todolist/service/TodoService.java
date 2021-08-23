package org.prgms.todolist.service;

import org.prgms.todolist.entity.TodoDTO;

import java.util.List;

public interface TodoService {

    TodoDTO.Read createTodo(TodoDTO.Create request);

    TodoDTO.Read readTodo(long id);

    TodoDTO.Read updateTodo(long id, TodoDTO.Update request);

    void deleteTodo(long id);

    List<TodoDTO.Read> readTodos();

    List<TodoDTO.Read> readTodosByStatus(boolean done);
}
