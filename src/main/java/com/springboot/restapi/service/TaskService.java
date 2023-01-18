package com.springboot.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.model.Task;
import com.springboot.restapi.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    // Create task
    public Task addTask(Task task) {
        return repository.save(task);
    }

    // Get tasks
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Get task by Id
    public Task getTaskByTaskId(String taskId) {
        return repository.findById(taskId).get();
    }

    // Get task by Severity
    public List<Task> getTaskBySeverity(int severity) {
        return repository.findBySeverity(severity);
    }

    // Get task by Assignee
    public List<Task> getTaskByAssignee(String assignee) {
        return repository.getTasksByAssignee(assignee);
    }

    // Update task by taskId
    public Task updateTask(String taskId, Task taskRequest) {
        // Get existing document from DB
        Task existingTask = repository.findById(taskId).get();

        // Populate new value from request to existing object/entity/document
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());

        return repository.save(existingTask);

    }

    // Delete task by Id
    public String deleteTask(String taskId) {
        repository.deleteById(taskId);

        return taskId + " task deleted successully.";
    }
    
}
