package com.example.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    List<TaskEntity> getAllTasks(){
        return  tasksRepository.findAll();
    }

    TaskEntity addNewTask(String taskName){
        TaskEntity task = new TaskEntity(taskName);
        TaskEntity savedTask = tasksRepository.save(task);
        return savedTask;
    }
}
