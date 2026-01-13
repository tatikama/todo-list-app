package ru.kamalova.todo_list_app.handler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalExceptionHandlerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRuntimeExceptionHandling() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/throw-error")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Internal server error"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("Simulated runtime error"));
    }

    @Test
    public void testIllegalArgumentExceptionHandling() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/invalid-input")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Invalid input data"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("Invalid input provided"));
    }

    @Test
    public void testDataIntegrityViolationExceptionHandling() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/db-violation")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isConflict())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Database constraint violation"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.detail").value("Database constraint violated"));
    }
}