package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProject() {
        return projectService.getProject();
    }

    @PostMapping
    public void registerProject(@RequestBody Project project) {
        projectService.addNewProject(project);
    }

    @DeleteMapping(path = "{projectId}")
    public void deleteProject(@PathVariable("projectId") Long projectId) {
        projectService.deleteProject(projectId);
    }

    @PutMapping(path = "{projectId}")
    public void upateProject(
            @PathVariable("projectId") Long projectId,
            @RequestParam(required = false) String projectName,
            @RequestParam(required = false) String researchMethod,
            @RequestParam(required = false) String describe,
            @RequestParam(required = false) LocalDate dateCreate
    ) {
        projectService.updateProject(projectId, projectName, researchMethod, describe, dateCreate);
    }
}
