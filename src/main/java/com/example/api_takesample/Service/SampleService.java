package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Project;
import com.example.api_takesample.Model.Sample;
import com.example.api_takesample.Model.Task;
import com.example.api_takesample.Repository.ProjectRepository;
import com.example.api_takesample.Repository.SampleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    @Autowired
    SampleRepository sampleRepository;
    ProjectRepository projectRepository;

    public SampleService(SampleRepository sampleRepository, ProjectRepository projectRepository) {
        this.sampleRepository = sampleRepository;
        this.projectRepository = projectRepository;
    }


    public List<Sample> getSample() {
        return sampleRepository.findAll();
    }


    public void addNewSample(Sample sample) {
        Optional<Sample> sampleOptional = sampleRepository
                .findById(sample.getIdSample());

        if (sampleOptional.isPresent())
            throw new IllegalStateException(
                    "Id sample taken"
            );

        sampleRepository.save(sample);
    }

    public void deleteSample(Long sampleId) {
        boolean exist = sampleRepository.existsById(sampleId);
        if (!exist) throw new IllegalStateException(
                "Sample with id " + sampleId + " does not exist"
        );

        sampleRepository.deleteById(sampleId);
    }

    @Transactional
    public void updateSample(Long sampleId, String nameSample, LocalDate createDate) {
        Sample sample = sampleRepository.findById(sampleId).orElseThrow(
                () -> new IllegalStateException(
                "Sample with id " + sampleId + " does not exist"
        )
        );

        if (nameSample != null &&
                !nameSample.equals(sample.getNameSample())) {
            sample.setNameSample(nameSample);
        }

        if (createDate != null &&
                !createDate.equals(sample.getCreateDate())) {
            sample.setCreateDate(createDate);
        }
    }

    public List<Sample> getSampleById(Long sampleId) {
        boolean exist = sampleRepository.existsById(sampleId);

        if (!exist) throw new IllegalStateException(
                "sample with id " + sampleId + " does not exist"
        );

        return sampleRepository.findSampleByIdSample(sampleId);
    }

    public List<Sample> getSampleByProjectId(Long projectId) {
        return sampleRepository.findByProjectIdProject(projectId);
    }

    public void addNewSampleInProject(Long projectId, Sample sample) {
        boolean isProjectExist = projectRepository.existsById(projectId);
        if (!isProjectExist) throw new IllegalStateException(
                "Project with id " + projectId + " does not exits"
        );


        Optional<Sample> sampleOptional = sampleRepository
                .findById(sample.getIdSample());

        if (sampleOptional.isPresent())
            throw new IllegalStateException(
                    "Sample id have taken"
            );

        Optional<Project> projectOptional = projectRepository
                .findById(projectId);
        sample.setProject(projectOptional.get());
        sampleRepository.save(sample);
    }
}
