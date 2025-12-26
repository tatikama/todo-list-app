package ru.kamalova.todo_list_app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class TaskService {

        private List<Task> tasks = new ArrayList<>();

        public void add(Task task) {
            tasks.add(task);
        }

        public List<Task> getAll() {
            return tasks;
        }
    }
