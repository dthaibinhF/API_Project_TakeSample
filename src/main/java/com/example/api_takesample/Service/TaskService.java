package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Model.Task;
import com.example.api_takesample.Repository.ProjectRepository;
import com.example.api_takesample.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    ProjectRepository projectRepository;
    TaskRepository taskRepository;

    public TaskService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public void addNewTask(Long projectId, Task task) {
        boolean isProjectExist = projectRepository.existsById(projectId);
        if (!isProjectExist) throw new IllegalStateException(
                "Project with id " + projectId + " does not exits"
        );

        Optional<Task> taskOptional = taskRepository
                .findById(task.getIdTask());

        if (taskOptional.isPresent())
            throw new IllegalStateException(
                    "Task id have taken"
            );

        Optional<Project> projectOptional = projectRepository
                .findById(projectId);
        task.setProject(projectOptional.get());
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exist = taskRepository.existsById(taskId);

        if (!exist) throw new IllegalStateException(
                "Task with id " + taskId + " does not exist"
        );

        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Long taskId, LocalDate startTime, LocalDate deadline, String direction) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new IllegalStateException(
                        "Task with id " + taskId + " does not exist"
                )
        );

        if (startTime != null &&
                !startTime.equals(task.getStartTime())) {
            task.setStartTime(startTime);
        }

        if (deadline != null &&
                !deadline.equals(task.getDeadline())) {
            task.setDeadline(deadline);
        }

        if (direction != null &&
                !direction.isEmpty() &&
                !Objects.equals(direction, task.getDirection())) {
            task.setDirection(direction);
        }
    }

    public List<Task> getTaskById(Long taskId) {
        boolean exist = taskRepository.existsById(taskId);

        if (!exist) throw new IllegalStateException(
                "Task id " + taskId + " does not exist"
        );

        return taskRepository.findTaskByIdTask(taskId);
    }

    public List<Task> getTaskByProjectId(Long projectId) {
        if (!projectRepository.existsById(projectId))
            throw new IllegalStateException(
                    "Project with id " + projectId + " does not exist"
            );
        return taskRepository.findTaskByProjectIdProject(projectId);
    }
}
