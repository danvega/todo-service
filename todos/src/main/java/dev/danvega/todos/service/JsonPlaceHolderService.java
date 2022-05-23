package dev.danvega.todos.service;

import dev.danvega.todos.model.Todo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JsonPlaceHolderService {

    private final RestTemplate restTemplate;

    public JsonPlaceHolderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Todo> getTodosFromJsonPlaceHolder() {
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/todos",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Todo>>() {
                }).getBody();
    }

}
