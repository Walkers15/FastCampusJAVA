package com.example.todoserver.web;

import com.example.todoserver.model.TodoModel;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.model.TodoResponse;
import com.example.todoserver.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {
    private final TodoService service;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest todoRequest) {
        log.info("Create");
        if (ObjectUtils.isEmpty(todoRequest.getTitle())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(todoRequest.getOrder())) {
            todoRequest.setOrder(0L);
        }

        if (ObjectUtils.isEmpty(todoRequest.getCompleted())) {
            todoRequest.setCompleted(false);
        }

        TodoModel result = this.service.add(todoRequest);
        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Long id) {
        log.info("Read One");
        return ResponseEntity.ok(new TodoResponse(this.service.searchById(id)));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        List<TodoModel> list = this.service.searchAll();
        List<TodoResponse> response = list.stream().map(TodoResponse::new).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
        log.info("Update");

        return ResponseEntity.ok(new TodoResponse(this.service.updateById(id, todoRequest)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {
        this.service.deleteById(id);
        log.info("Delete");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll() {
        log.info("Delete All");
        this.service.deleteAll();
        return ResponseEntity.ok().build();
    }
}
