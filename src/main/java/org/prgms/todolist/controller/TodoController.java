package org.prgms.todolist.controller;

import org.prgms.todolist.entity.TodoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @PostMapping
    public ResponseEntity<TodoDTO.Read> createTodo(Object todoInfo) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDTO.Read> readTodo(@PathVariable(name = "id") long id) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO.Read>> readStatusTodos(@RequestParam(name = "status") String status) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDTO.Read> updateTodo(@PathVariable(name = "id") long id, Object updatedInfo) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable(name = "id") long id) {

    }

    @PatchMapping("/{id}/{status}")
    public ResponseEntity<TodoDTO.Read> toggleTodo(@PathVariable(name = "id") long id, @PathVariable(name = "status") String status){
        return null;
    }
}
