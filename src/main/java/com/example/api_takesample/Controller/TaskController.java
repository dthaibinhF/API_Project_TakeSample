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

    @GetMapping("/{taskId}")
    public List<Task> getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/project/{projectId}")
    public List<Task> getTaskByProjectId(@PathVariable("projectId") Long projectId) {
        return taskService.getTaskByProjectId(projectId);
    }

    @PostMapping("/{projectId}")
    public void registerTask(
            @PathVariable Long projectId,
            @RequestBody Task task) {
        taskService.addNewTask(projectId, task);
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
