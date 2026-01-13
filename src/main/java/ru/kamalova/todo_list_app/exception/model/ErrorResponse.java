package ru.kamalova.todo_list_app.exception.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;
    private String detail;

    public ErrorResponse(String message, String detail) {
        this.message = message;
        this.detail = detail;
    }

}
