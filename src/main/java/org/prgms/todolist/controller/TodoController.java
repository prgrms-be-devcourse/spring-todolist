package org.prgms.todolist.controller;

import org.prgms.todolist.entity.Todo;
import org.prgms.todolist.entity.TodoDTO;
import org.prgms.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
// @CrossOrigin
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<TodoDTO.Read> createTodo(TodoDTO.Create todoInfo) {
        TodoDTO.Read createdTodo = todoService.createTodo(todoInfo);
        return ResponseEntity.created(URI.create(String.format("/todos/%d", createdTodo.getId()))).body(createdTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO.Read> readTodo(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(todoService.readTodo(id));
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO.Read>> readStatusTodos(@RequestParam(name = "status") String status) {
        List<TodoDTO.Read> todos;
        switch(status) {
            case "ACTIVE":
                todos = todoService.readTodosByStatus(false);
                break;

            case "COMPLETE":
                todos = todoService.readTodosByStatus(true);
                break;

            default:
                todos = todoService.readTodos();
                break;
        }

        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO.Read> updateTodo(@PathVariable(name = "id") long id, TodoDTO.Update updatedInfo) {
        return ResponseEntity.ok(todoService.updateTodo(id, Todo.Updatable.content, updatedInfo.getContent()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(name = "id") long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/{status}")
    public ResponseEntity<TodoDTO.Read> toggleTodo(@PathVariable(name = "id") long id, @PathVariable(name = "status") String status){
        return ResponseEntity.ok(todoService.updateTodo(id, Todo.Updatable.done, status));
    }
}
