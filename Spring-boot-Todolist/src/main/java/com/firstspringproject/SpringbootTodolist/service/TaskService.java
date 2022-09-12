package com.firstspringproject.SpringbootTodolist.service;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskService implements TaskServable {
   @Autowired
    private TaskRepository taskRepository ;
    public Task saveTask(Task task ){
        System.out.println(task.toString());
        return taskRepository.save(task);

    }

    public List<Task> fetchalltasks() {

        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long id ) {
        return  taskRepository.findById(id).get();
    }

    @Override
    public void deleteTask(Long taskId) {
         taskRepository.deleteById(taskId);
         return;
    }

    @Override
    public Task updateTask(Long taskId, Task task) {

      var oldtask =  taskRepository.findById(taskId).get();
        if (task.getMessage()  != null)
            oldtask.setMessage( task.getMessage() );

        if (task.isCompleted() != oldtask.isCompleted())
            oldtask.setCompleted(task.isCompleted());

        if (task.getTaskId() != oldtask.getTaskId() )
            oldtask.setTaskId(task.getTaskId() );

        return taskRepository.save(oldtask);
    }

}
