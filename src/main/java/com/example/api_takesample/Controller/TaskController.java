package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Task;
import com.example.api_takesample.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {

    TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTask() {
        return taskService.getTask();
    }

    @PostMapping
    public void registerTask(@RequestBody Task task) {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void updateTask(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) LocalDate startTime,
            @RequestParam(required = false) LocalDate deadline,
            @RequestParam(required = false) String direction
            ){
        taskService.updateTask(taskId, startTime, deadline, direction);
    }
}
