package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    public void addNewProject(Project project) {
        Optional<Project> projectOptional = projectRepository
                .findById(project.getIdProject());
        if (projectOptional.isPresent())
            throw new IllegalStateException(
                    "Id project have existed"
            );
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        boolean exist = projectRepository.existsById(projectId);
        if (!exist) {
            throw new IllegalStateException(
                    "Project with id " + projectId + " does not exist"
            );
        }

        projectRepository.deleteById(projectId);
    }

    @Transactional
    public void updateProject(Long projectId, String projectname, String researchMethod, String describe, LocalDate dateCreate) {
        Project project = projectRepository.findById(projectId).orElseThrow(
                () -> new IllegalStateException(
                        "User with id " + projectname + " does not exist"
                )
        );

        if (projectname != null &&
                !projectname.isEmpty() &&
                !Objects.equals(project.getProjectName(), projectname)) {
            project.setProjectName(projectname);
        }

        if (researchMethod != null &&
                !researchMethod.isEmpty() &&
                !Objects.equals(project.getResearchMethod(), researchMethod)) {
            project.setResearchMethod(researchMethod);
        }

        if (describe != null &&
                !describe.isEmpty() &&
                !Objects.equals(project.getDescribe(), describe)) {
            project.setDescribe(describe);
        }

        if (dateCreate != null &&
                !Objects.equals(project.getDateCreate(), dateCreate)) {
            project.setDateCreate(dateCreate);
        }
    }
}
