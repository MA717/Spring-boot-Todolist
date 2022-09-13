package com.firstspringproject.SpringbootTodolist.service;

import com.firstspringproject.SpringbootTodolist.entity.Task;

import java.util.List;
import java.util.UUID;

public interface TaskServable {
     Task saveTask(Task task );
      List<Task> fetchalltasks();

     Task getTask(UUID id );

    void deleteTask(UUID taskId);

    Task updateTask(UUID taskId, Task task);
}
