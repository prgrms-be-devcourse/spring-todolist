package org.prgms.todolist.service;

import org.prgms.todolist.entity.Todo;
import org.prgms.todolist.entity.TodoDTO;
import org.prgms.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class BasicTodoService implements TodoService {

    private final TodoRepository todoRepository;

    public BasicTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    private Supplier<RuntimeException> noTodoFoundException(long id) {
        return () -> new NoSuchElementException(String.format("To-do #%d does not exist.", id));
    }

    @Override
    public TodoDTO.Read createTodo(TodoDTO.Create request) {
        Todo todo = new Todo(request.getContent());
        todoRepository.save(todo);
        return new TodoDTO.Read(todo);
    }

    @Override
    public TodoDTO.Read readTodo(long id) {
        return new TodoDTO.Read(todoRepository.findById(id).orElseThrow(noTodoFoundException(id)));
    }

    @Override
    public TodoDTO.Read updateTodo(long id, Todo.Updatable field, String value) {
        Todo todo = todoRepository.findById(id).orElseThrow(noTodoFoundException(id));
        switch(field) {
            case done:
                switch(value) {
                    case Todo.NOT_DONE:
                        todo.setDone(false);
                        break;

                    case Todo.DONE:
                        todo.setDone(true);
                        break;
                }
                break;

            case content:
                todo.updateContent(value);
                break;
        }
        return new TodoDTO.Read(todo);
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<TodoDTO.Read> readTodos() {
        return todoRepository.findAll().stream().map(TodoDTO.Read::new).collect(Collectors.toList());
    }

    @Override
    public List<TodoDTO.Read> readTodosByStatus(boolean done) {
        return todoRepository.findAllByDone(done).stream().map(TodoDTO.Read::new).collect(Collectors.toList());
    }
}
