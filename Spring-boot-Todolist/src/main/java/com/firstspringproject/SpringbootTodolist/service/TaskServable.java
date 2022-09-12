package com.firstspringproject.SpringbootTodolist.service;

import com.firstspringproject.SpringbootTodolist.entity.Task;

import java.util.List;

public interface TaskServable {
     Task saveTask(Task task );
      List<Task> fetchalltasks();

     Task getTask(Long id );

    void deleteTask(Long taskId);

    Task updateTask(Long taskId, Task task);
}
