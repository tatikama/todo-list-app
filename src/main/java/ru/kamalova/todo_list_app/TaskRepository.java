package ru.kamalova.todo_list_app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    // Методы save() и findAll() предоставляются автоматически
}