package com.firstspringproject.SpringbootTodolist.TestContainer;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.repository.TaskRepository;
import com.mysql.cj.jdbc.ConnectionImpl;
import org.assertj.core.api.Assertions;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Testcontainers
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)


public class TestContainer {

    @Autowired
    TaskRepository taskRepository;




    @Test
    public void delete_task_from_DB() {
        Task task = Task.builder()
                .Message("Hello World")
                .Completed(true)
                .build();
        taskRepository.save(task);

        taskRepository.deleteById(task.getUuid());
        List<Task> tasks = taskRepository.findAll();

        assertThat(tasks).hasSize(0);
    }

    @Test
    void db_should_be_empty() {
        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks).hasSize(0);
    }


    @DisplayName("Test to check wether the task can be found ")
    @Test
    public void save_task_from_DB() {

        Task task = Task.builder()
                .Message("Hi")
                .Completed(false)
                .build();

        taskRepository.save(task);

        Task task1 = taskRepository.findById(task.getUuid()).get();
        assertEquals(task.getUuid(), task1.getUuid());
        taskRepository.deleteById(task.getUuid());
    }


    @Test
    public void update_task_from_DB() {

        Task task = Task.builder()
                .Message("hello World")
                .Completed(true)
                .build();

        taskRepository.save(task);

        task.setMessage("hello World Updated !");
        taskRepository.save(task);

        Task taskResult = taskRepository.findById(task.getUuid()).get();
        assertEquals(taskResult.getMessage(), "hello World Updated !");

    }


}
