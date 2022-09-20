package com.firstspringproject.SpringbootTodolist.service;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    //@Autowired
    @InjectMocks
    private TaskService taskService;


   // @MockBean
    @Mock
    private TaskRepository taskRepository;


    @BeforeEach
    void setUp() {

        UUID uuid1 = UUID.fromString("1c0f8c59-fd42-4bd7-9f06-abff90b647b6");
        Task task = Task.builder()
                .uuid(uuid1)
                .Message("Hello Wolrd")
                .Completed(false)
                .build();

        Mockito.when(taskRepository.findById(uuid1)).thenReturn(Optional.ofNullable(task));

    }


    @Test
    public void validID() {
        // return task by id
        UUID uuid = UUID.fromString("1c0f8c59-fd42-4bd7-9f06-abff90b647b6");
        Task task = taskService.getTask(uuid);
        assertEquals(task.getUuid().toString(), uuid.toString());

    }
}