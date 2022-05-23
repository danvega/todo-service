package dev.danvega.todos.controller;

import dev.danvega.todos.model.Todo;
import dev.danvega.todos.repository.TodoRepository;
import dev.danvega.todos.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final Logger log = LoggerFactory.getLogger(TodoController.class);
    private final TodoRepository repository;
    private final TodoService service;

    public TodoController(TodoRepository repository, TodoService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public Iterable<Todo> findAll() {
        return repository.findAll();
    }

    @GetMapping("/transfer-one/{id}")
    public void transfer(@PathVariable Integer id) {
        Boolean sent = false;
        Optional<Todo> todo = repository.findById(id);
        if(todo.isPresent()) {
            log.info("Sending todo: {}", todo.get());
            sent = service.transferOne(todo.get());
        }
        log.info("Todo was sent to Personal Todo Service: {}", sent);
    }

    @GetMapping("/transfer-all")
    public void transferAll() {
        Iterable<Todo> todos = repository.findAll();
        log.info("Sending a total of {} todos to Personal Todo Service", StreamSupport.stream(todos.spliterator(),false).count());
        Boolean sent = service.transferAll(todos);
        log.info("Todos were sent to Personal Todo Service: {}", sent);
    }

}
