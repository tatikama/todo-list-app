package ru.kamalova.todo_list_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kamalova.todo_list_app.mapper.TaskMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    // Метод для получения всех задач
    public List<Task> getAll() {
        return StreamSupport.stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // Метод для получения задачи по Id
    public Optional<TaskDTO> getTaskById(Long id) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        return taskOptional.map(taskMapper::toDto);
    }

    // Метод для создания новой задачи
    public void createTask(CreateTaskDTO dto) {
        Task task = taskMapper.fromDto(dto);
        taskRepository.save(task);
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