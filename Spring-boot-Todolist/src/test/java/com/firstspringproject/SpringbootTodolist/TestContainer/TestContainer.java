package com.firstspringproject.SpringbootTodolist.TestContainer;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.NONE)
@Testcontainers

public class TestContainer {

    @Autowired
    TaskRepository taskRepository;
    @Container
    MySQLContainer  container= new MySQLContainer("mysql:8.0.26");

    @Test
    void db_should_be_empty(){
        List<Task> tasks = taskRepository.findAll();
        assertThat(tasks).hasSize(2);
    }

}
