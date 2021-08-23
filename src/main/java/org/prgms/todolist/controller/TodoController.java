package org.prgms.todolist.controller;

import org.prgms.todolist.entity.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @PostMapping
    public ResponseEntity<Todo.Read> createTodo(Object todoInfo) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo.Read> readTodo(@PathVariable(name = "id") long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<Todo.Read>> readStatusTodos(@RequestParam(name = "status") String status) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo.Read> updateTodo(@PathVariable(name = "id") long id, Object updatedInfo) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable(name = "id") long id) {

    }

    @PatchMapping("/{id}/{status}")
    public ResponseEntity<Todo.Read> toggleTodo(@PathVariable(name = "id") long id, @PathVariable(name = "status") String status){
        return null;
    }
}
