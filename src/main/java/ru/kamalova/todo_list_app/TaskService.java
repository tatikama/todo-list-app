package ru.kamalova.todo_list_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void add(Task task) {
        taskRepository.save(task); // Сохраняем задачу через репозиторий
    }

    public List<Task> getAll() {
        Iterable<Task> iterable = taskRepository.findAll();
        List<Task> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }
}