package ru.kamalova.todo_list_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.kamalova.todo_list_app.controller.TaskController;
import ru.kamalova.todo_list_app.model.Task;
import ru.kamalova.todo_list_app.service.TaskService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TaskController.class)
public class TaskControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TaskService taskService;

    @Test
    void getAllTasks_ShouldReturnList() throws Exception {
        Task t1 = new Task("Task 1", false);
        t1.setId(1L);
        Task t2 = new Task("Task 2", true);
        t2.setId(2L);

        when(taskService.getAll()).thenReturn(List.of(t1, t2));

        mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Task 1"))
                .andExpect(jsonPath("$[1].done").value(true));
    }

    @Test
    void createTask_ShouldReturn201() throws Exception {
        doNothing().when(taskService).add(any(Task.class));

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"New Task","done":false}
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("New Task"))
                .andExpect(jsonPath("$.done").value(false));
    }

    @Test
    void createTask_WhenTitleIsBlank_ShouldReturn400WithErrorBody() throws Exception {
        doNothing().when(taskService).add(any(Task.class));

        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"title":"","done":false}
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("Title must not be blank"));
    }

    @Test
    void createTask_WhenInvalidJson_ShouldReturn400() throws Exception {
        mockMvc.perform(post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{invalid_json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorCode").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("Malformed JSON request"));
    }
}