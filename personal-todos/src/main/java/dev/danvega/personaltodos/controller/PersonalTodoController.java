package dev.danvega.personaltodos.controller;

import dev.danvega.personaltodos.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class PersonalTodoController {

    private final Logger log = LoggerFactory.getLogger(PersonalTodoController.class);

    @PostMapping("/receive-one")
    public Boolean receiveOne(@RequestBody Todo todo) {
        log.info("PersonalTodoController received todo: {}", todo);
        return true;
    }

    @PostMapping("/receive-all")
    public Boolean receiveAll(@RequestBody List<Todo> todos) {
        log.info("PersonalTodoController received {} todos: ", todos.size());
        return true;
    }
}
