package com.firstspringproject.SpringbootTodolist.Controller;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import com.firstspringproject.SpringbootTodolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/task")
    public Task saveTask(@Valid @RequestBody Task task ){
        return taskService.saveTask(task);
    }

    @GetMapping("/task")
    public List<Task> getTasks()
    {
        return taskService.fetchalltasks();
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable("id") UUID taskId)
    {
        return taskService.getTask( taskId);
    }


    @DeleteMapping("/task/{id}")
    public String deleteTask(@PathVariable("id") UUID taskId )
    {
         taskService.deleteTask(taskId);
         return "Task was deleted Successfully ";
    }


    @PutMapping("/task/{id}")
    public Task updateTask(@RequestBody Task task , @PathVariable("id") UUID taskId )
    {
       return taskService.updateTask( taskId , task ) ;
    }
}
