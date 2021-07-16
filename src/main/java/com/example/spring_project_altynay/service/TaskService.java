package com.example.spring_project_altynay.service;

import com.example.spring_project_altynay.Repository.TaskRepository;
import com.example.spring_project_altynay.db.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public void addTask(Task task)
    {
         taskRepository.save(task);
    }

    public List<Task>tasks()
    {
        return taskRepository.findAll();
    }
    public void update(Task task)
    {
       taskRepository.save(task);
    }

    public Task getTask(Long id)
    {
        Optional<Task>task=taskRepository.findById(id);
        return task.orElse(null);
    }

    public void deleteTask(Task task)
    {
        taskRepository.delete(task);
    }

}
