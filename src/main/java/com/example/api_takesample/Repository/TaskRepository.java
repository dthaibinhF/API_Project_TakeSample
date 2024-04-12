package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByIdTask(Long taskId);
    List<Task> findTaskByProjectIdProject(Long projectId);
}
