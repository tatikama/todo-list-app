package ru.kamalova.todo_list_app;

import java.time.LocalDateTime;

public class Task {
    public String title;
    public boolean done;
    public LocalDateTime createdAt;

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
        this.createdAt = LocalDateTime.now();
    }
}
