package ru.kamalova.todo_list_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private TaskService taskService; // Предполагается, что у вас есть TaskService

    @GetMapping("/hello")
    public String hello() {
        return "Привет!";
    }

    @GetMapping("/task")
    public Task getFirstTask() {
        // Возврат первой задачи из базы данных
        List<Task> tasks = taskService.getAll();
        if (!tasks.isEmpty()) {
            return tasks.get(0); // Возвращаем первую задачу
        }
        return new Task("Нет задач", true); // Или возвращаем фиктивную задачу
    }
}