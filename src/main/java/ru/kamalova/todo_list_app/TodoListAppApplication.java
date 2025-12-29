package ru.kamalova.todo_list_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoListAppApplication {

	public static void main(String[] args) {
		System.out.println("Starting the Todo List App...");
		SpringApplication.run(TodoListAppApplication.class, args);
	}
}