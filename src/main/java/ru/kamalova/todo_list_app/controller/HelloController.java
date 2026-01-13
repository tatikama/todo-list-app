package ru.kamalova.todo_list_app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kamalova.todo_list_app.model.Task;
import ru.kamalova.todo_list_app.service.TaskService;

import java.util.List;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private TaskService taskService;

    @GetMapping("/hello")
    public String hello() {
        return "Привет!";
    }

    @GetMapping("/task")
    public Task getFirstTask() {
        LOGGER.debug("Получение первой задачи.");
        List<Task> tasks = taskService.getAll();
        if (!tasks.isEmpty()) {
            return tasks.get(0);
        } else {
            LOGGER.warn("Список задач пуст, возвращаем фиктивную задачу.");
            return new Task("Нет задач", true);
        }
    }
}