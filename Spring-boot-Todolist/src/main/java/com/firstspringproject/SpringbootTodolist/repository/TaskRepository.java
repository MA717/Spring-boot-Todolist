package com.firstspringproject.SpringbootTodolist.repository;

import com.firstspringproject.SpringbootTodolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task,UUID> {
    void deleteById(UUID taskId);


    Optional<Task> findById(UUID id);
}
