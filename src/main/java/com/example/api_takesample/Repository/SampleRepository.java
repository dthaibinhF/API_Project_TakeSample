package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

    List<Sample> findSampleByIdSample(Long sampleId);
    List<Sample> findByProjectIdProject(Long projectId);
}
