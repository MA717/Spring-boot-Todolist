package com.firstspringproject.SpringbootTodolist.Controller;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.UUID;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskService taskService;

    Task task;

    @BeforeEach()
    void setUp() {
        task = Task.builder()
                .Message("Sleep Early")
                .Completed(false)
                .uuid(UUID.randomUUID())
                .build();


    }

    @Test
    void saveTask() throws Exception {


        Task inTask = Task.builder()
                .Message("Sleep Early")
                .Completed(false)
                .build();

        Mockito.when(taskService.saveTask(inTask)).thenReturn(task);


        mockMvc.perform(MockMvcRequestBuilders.post("/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"message\": \" Sleep Early\",\n" +
                        "\t\"completed\":false\n" +
                        "\n" +
                        "}")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void getTask() throws Exception {
        UUID uuid1 = UUID.randomUUID();
        Task task = Task.builder()
                .uuid(uuid1)
                .Message("Sleep Early")
                .Completed(false)
                .build();
        Mockito.when(taskService.getTask(uuid1)).thenReturn(task);

        mockMvc.perform(MockMvcRequestBuilders.get("/task/" + uuid1.toString())
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value(task.getMessage()));
    }
}