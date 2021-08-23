package org.prgms.todolist.service;

import org.prgms.todolist.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicTodoService implements TodoService {

    public BasicTodoService() {
    }

    @Override
    public Todo.Read createTodo(Todo.Create request) {
        return null;
    }

    @Override
    public Todo.Read readTodo(long id) {
        return null;
    }

    @Override
    public Todo.Read updateTodo(Todo.Update request) {
        return null;
    }

    @Override
    public void deleteTodo(long id) {

    }

    @Override
    public List<Todo.Read> readTodos() {
        return null;
    }

    @Override
    public List<Todo.Read> readTodosByStatus(boolean done) {
        return null;
    }
}
