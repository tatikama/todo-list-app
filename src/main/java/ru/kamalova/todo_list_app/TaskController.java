package ru.kamalova.todo_list_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Добавляет новую задачу и возвращает её с состоянием успеха.
     */
    @PostMapping("/tasks")
    public ResponseEntity<?> add(@RequestBody Task task) {
        taskService.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    /**
     * Возвращает список всех задач.
     */
    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.getAll();
    }
}