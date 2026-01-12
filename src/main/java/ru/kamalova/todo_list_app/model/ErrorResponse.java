package ru.kamalova.todo_list_app.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String detail;

    public ErrorResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

    // Геттеры и сеттеры
}
