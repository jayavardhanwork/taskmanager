package com.example.taskmanager.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RequestMapping("/tasks")
@RestController
public class TasksController {
    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskEntity>> getAllTasks(){
        return ResponseEntity.ok(tasksService.getAllTasks());
    }

    @PostMapping("")
    ResponseEntity<TaskEntity> createTask(@RequestBody CreateTaskRequestBody body){
        TaskEntity savedTask = tasksService.addNewTask(body.name);
        return ResponseEntity.created(URI.create(Constant.BASE_URL + "/tasks/" + "savedTask.id")).body(savedTask);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskEntity> getTaskById(@PathVariable Long id){
        Optional<TaskEntity> task = tasksService.getTaskById(id);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        }
        else{
            return ResponseEntity.status(404).body(null);
        }
    }

    @PatchMapping("")
    ResponseEntity<TaskEntity> editTaskById(@RequestBody CreateTaskRequestBody body){
        Optional<TaskEntity> task = tasksService.editTask(body.id, body.name);
        if(task.isPresent()){
            return ResponseEntity.ok(task.get());
        }
        else{
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("{id}")
    ResponseEntity<TaskEntity> deleteTaskById(@PathVariable Long id){
        tasksService.deleteTaskById(id);
       return ResponseEntity.ok(null);
    }
}
