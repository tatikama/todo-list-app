package ru.kamalova.todo_list_app;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "todo_items")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean done;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
        public class TaskDTO {
            private Long id;
            private String title;
            private boolean completed;
        }

    public Task() {}
        public class CreateTaskDTO {
            private String title;
        }

    private boolean completed;

    // Геттер и сеттер для поля completed
    public boolean isCompleted() {
        return completed;
    }

}