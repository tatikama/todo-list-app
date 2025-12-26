package ru.kamalova.todo_list_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public Task add(@RequestBody Task task) {
        taskService.add(task); // Просто добавляем задачу
        return task;
    }

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll(); // Получаем все задачи
    }
}