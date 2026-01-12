package ru.kamalova.todo_list_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.dao.DataIntegrityViolationException;

@RestController
public class TestController {

    @GetMapping("/throw-error")
    public String throwError() {
        throw new RuntimeException("Simulated runtime error");
    }

    @GetMapping("/invalid-input")
    public String invalidInput() {
        throw new IllegalArgumentException("Invalid input provided");
    }

    @GetMapping("/db-violation")
    public String databaseViolation() {
        throw new DataIntegrityViolationException("DB constraint violated");
    }
}