package dev.danvega.todos.service;

import dev.danvega.todos.model.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TodoService {

    @Value("${personal-todo-service-url}")
    private String serviceURL;
    private final RestTemplate restTemplate;

    public TodoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean transferOne(Todo todo) {
        return restTemplate.postForEntity(serviceURL + "/receive-one", todo, Boolean.class).getBody();
    }

    public Boolean transferAll(Iterable<Todo> todos) {
        return restTemplate.postForEntity(serviceURL + "/receive-all", todos, Boolean.class).getBody();
    }
}
