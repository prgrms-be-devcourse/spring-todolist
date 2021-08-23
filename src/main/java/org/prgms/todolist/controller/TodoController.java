package org.prgms.todolist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @PostMapping
    public ResponseEntity<Object> createTodo(Object todoInfo) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> readTodo(@PathVariable(name = "id") long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<Object> readStatusTodos(@RequestParam(name = "status") String status) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable(name = "id") long id, Object updatedInfo) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable(name = "id") long id) {
        return null;
    }

    @PatchMapping("/{id}/{status}")
    public ResponseEntity<Object> toggleTodo(@PathVariable(name = "id") long id, @PathVariable(name = "status") String status){
        return null;
    }
}
