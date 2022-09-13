package com.firstspringproject.SpringbootTodolist.service;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TaskService implements TaskServable {
   @Autowired
    private TaskRepository taskRepository ;
    public Task saveTask(Task task ){
        return taskRepository.save(task);

    }

    public List<Task> fetchalltasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task getTask(UUID id ) {
        return  taskRepository.findById(id).get();
    }

    @Override
    public void deleteTask(UUID taskId) {
         taskRepository.deleteById(taskId);
         return;
    }

    @Override
    public Task updateTask(UUID taskId, Task task) {

      var oldtask =  taskRepository.findById(taskId).get();
        if (task.getMessage()  != null)
            oldtask.setMessage( task.getMessage() );

        if (task.isCompleted() != oldtask.isCompleted())
            oldtask.setCompleted(task.isCompleted());

        if (task.getUuid() != oldtask.getUuid() && task.getUuid()!= null )
                oldtask.setUuid(task.getUuid() );

        return taskRepository.save(oldtask);
    }

}
