package com.firstspringproject.SpringbootTodolist.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
    @Id
    private Long taskId;

    @NotBlank(message = "Message needed to be added")
    @Length(max =100 , min = 1 )
    private String Message;

   @NotNull(message = "Status of task needed to be added")
    private boolean Completed ;


    public Task(Long taskId, String message, boolean completed) {
        this.taskId = taskId;
        Message = message;
        Completed = completed;
    }

    public Task( )
    {

    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", Message='" + Message + '\'' +
                ", Completed=" + Completed +
                '}';
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public boolean isCompleted() {
        return Completed;
    }

    public void setCompleted(boolean completed) {
        Completed = completed;
    }
}
