package com.springboot.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.model.Task;
import com.springboot.restapi.service.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    // Create task
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        Task newTask = service.addTask(task);
        return newTask;
    }

    // Get all tasks
    @GetMapping
    public List<Task> getTasks() {
        return service.getAllTasks();
    }

    // Get task by taskId
    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return service.getTaskByTaskId(taskId);
    }

    // Get task by Severity
    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity) {
        return service.getTaskBySeverity(severity);
    }

    // Get task by Assignee
    @GetMapping("/assignee/{assignee}")
    public List<Task> findTaskUsingAssignee(String assignee) {
        return service.getTaskByAssignee(assignee);
    }

    // Update task by taskId
    @PutMapping("/{taskId}")
    public Task modifyTask(@PathVariable String taskId, @RequestBody Task task) {
        return service.updateTask(taskId, task);
    }

    // Delete task by taskId
    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId) {
        return service.deleteTask(taskId);
    }
    
}
