package ru.kamalova.todo_list_app.exception.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorCode;
    private String message;

    public ErrorResponse(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}