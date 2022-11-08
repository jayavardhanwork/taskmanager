package com.example.taskmanager.tasks;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<TaskEntity> getTaskById(Long id){
        Optional<TaskEntity> task = tasksRepository.findById(id);
        return task;
    }
    Optional<TaskEntity> editTask(Long id, String newName){
       Optional<TaskEntity> editedTask = tasksRepository.findById(id);
        if(editedTask.isPresent()){
            editedTask.get().name = newName;
            tasksRepository.save(editedTask.get());
        }
        return editedTask;
    }

    void deleteTaskById(Long id){
        tasksRepository.deleteById(id);
    }
}
