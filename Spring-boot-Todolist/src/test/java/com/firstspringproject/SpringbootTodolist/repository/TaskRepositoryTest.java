package com.firstspringproject.SpringbootTodolist.repository;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DataJpaTest
class TaskRepositoryTest {

    @Autowired
   private TaskRepository taskRepository ;

    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
  public void setUp() {

    }

    @DisplayName("Test to check wether the task can be found ")
    @Test
  public void getTaskById()
    {

        Task task = Task.builder()
                .Message("Hi")
                .Completed(false)
                .build();

        entityManager.persist(task);

        Task task1  =  taskRepository.findById(task.getUuid()).get() ;
        assertEquals(task.getUuid() , task1.getUuid());
    }







}