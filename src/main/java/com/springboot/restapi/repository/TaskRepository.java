package com.springboot.restapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.restapi.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

    List<Task> findBySeverity(int severity);

    @Query("{ assignee : ?0 }")
    List<Task> getTaskByAssignee(String assignee);

    Task findByTaskId(String taskId);
    
}