package com.springboot.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
// import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    public String taskId;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;

}
