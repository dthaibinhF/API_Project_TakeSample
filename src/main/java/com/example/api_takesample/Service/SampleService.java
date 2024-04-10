package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Sample;
import com.example.api_takesample.Repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SampleService {

    SampleRepository sampleRepository;

    @Autowired
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
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
}
