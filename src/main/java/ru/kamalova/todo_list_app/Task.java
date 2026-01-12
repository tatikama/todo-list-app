package ru.kamalova.todo_list_app;

import jakarta.persistence.*;
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

    // Пустой конструктор для JPA
    public Task() {}

    // Конструктор с параметрами (если он нужен для создания объекта)
    public Task(String title, boolean done) {
        this.title = title;
        this.done = done;
        this.createdAt = LocalDateTime.now();
    }

    // Метод, который автоматически выставляет timestamp при создании объекта
    @PrePersist
    protected void onCreate() {
        if (this.createdAt == null) {
            this.createdAt = LocalDateTime.now();
        }
    }
}
