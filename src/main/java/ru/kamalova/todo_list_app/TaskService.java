package ru.kamalova.todo_list_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Метод для получения всех задач
    public List<Task> getAll() {
        Iterable<Task> iterable = taskRepository.findAll();
        List<Task> result = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

    // Метод для получения задачи по Id
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Метод для преобразования Task в TaskDTO
    private TaskDTO convertToDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDone(task.isDone());
        return dto;
    }

    // Метод для преобразования CreateTaskDTO в Task
    private Task convertFromDto(CreateTaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDone(false); // Начальное значение
        return task;
    }

    // Метод для сохранения задачи
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    // Метод для добавления задачи
    public void add(Task task) {
        taskRepository.save(task);
    }

}