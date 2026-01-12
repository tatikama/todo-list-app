package ru.kamalova.todo_list_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/tasks")
    public ResponseEntity<?> add(@RequestBody Task task) {
        LOGGER.debug("Добавление новой задачи: {}", task);
        taskService.add(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAll() {
        LOGGER.debug("Получение всех задач.");
        return taskService.getAll();
    }

    @RestController
    public static class TestController {

        @GetMapping("/throw-runtime-error")
        public String throwRuntimeError() {
            throw new RuntimeException("Simulated runtime error");
        }

        @GetMapping("/throw-illegal-argument")
        public String throwIllegalArgument() {
            throw new IllegalArgumentException("Invalid input provided");
        }

        @GetMapping("/throw-data-integrity")
        public String throwDataIntegrity() {
            throw new DataIntegrityViolationException("Database constraint violated");
        }
    }
}