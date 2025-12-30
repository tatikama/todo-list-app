package ru.kamalova.todo_list_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TaskRepository {

    private final JdbcTemplate jdbc;

    @Autowired
    public TaskRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Task> findAll() {
        return jdbc.query("SELECT id, title, done, created_at FROM todo_items",
                (rs, rowNum) -> new Task(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getBoolean("done"),
                        rs.getObject("created_at", LocalDateTime.class)
                )
        );
    }

    public void save(Task task) {
        try {
            jdbc.update("INSERT INTO todo_items(title, done) VALUES (?, ?)",
                    new Object[]{
                            task.getTitle(),
                            task.isDone()

                    });
        } catch (DataAccessException e) {
            throw new RuntimeException("Ошибка при сохранении задачи.", e);
        }
    }

}