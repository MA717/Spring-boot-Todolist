package com.firstspringproject.SpringbootTodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    private Long taskId;

    @NotBlank(message = "Message needed to be added")
    @Length(max =100 , min = 1 )
    private String Message;

   @NotNull(message = "Status of task needed to be added")
    private boolean Completed ;




}
