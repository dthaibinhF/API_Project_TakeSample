package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Model.User;
import com.example.api_takesample.Repository.ProjectRepository;
import com.example.api_takesample.Repository.UserRepository;
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
    private final UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Autowired


    public List<Project> getProject() {
        return projectRepository.findAll();
    }

    public void addNewProject(Project project) {
        Optional<Project> projectOptional = projectRepository
                .findById(project.getIdProject());
        if (projectOptional.isPresent())
            throw new IllegalStateException(
                    "Id project taken"
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

    public List<Project> getProjectById(Long projectId) {
        boolean exist = projectRepository.existsById(projectId);
        if (!exist) throw new IllegalStateException(
                "Id project " + projectId + " does not exits"
        );
        return projectRepository.findByIdProject(projectId);
    }

    @Transactional
    public Project addUserToProject(Long userId, Long projectId) {
        userRepository.findById(userId).orElseThrow(
                () -> new IllegalStateException(
                        "User with id " + userId + " does not exist"
                )
        );

        projectRepository.findById(projectId).orElseThrow(
                () -> new IllegalStateException(
                        "Project with id " + projectId + " does not exist"
                )
        );

        User user = userRepository.findById(userId).get();
        Project project = projectRepository.findById(projectId).get();

        List<Project> projectListOfUser = user.getProjects();
        projectListOfUser.add(project);
        user.setProjects(projectListOfUser);
        return projectRepository.save(project);
    }
}
