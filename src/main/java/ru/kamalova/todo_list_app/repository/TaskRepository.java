package ru.kamalova.todo_list_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kamalova.todo_list_app.model.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}