package ru.kamalova.todo_list_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Привет!";
    }
    @GetMapping("/task")
    public Task getTask() {
        return new Task("Купить хлеб", false);
    }

}