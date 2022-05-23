package dev.danvega.todos;

import dev.danvega.todos.model.Todo;
import dev.danvega.todos.repository.TodoRepository;
import dev.danvega.todos.service.JsonPlaceHolderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class TodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(JsonPlaceHolderService service, TodoRepository repository) {
        return args -> {
            List<Todo> todos = service.getTodosFromJsonPlaceHolder();
            repository.saveAll(todos);
        };
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
