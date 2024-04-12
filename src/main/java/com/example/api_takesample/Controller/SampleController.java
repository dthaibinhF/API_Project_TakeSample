package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Sample;
import com.example.api_takesample.Service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/sample")
public class SampleController {

    SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping
    public List<Sample> getSample() {
        return sampleService.getSample();
    }

    @GetMapping("{sampleId}")
    public List<Sample> getSampleById(@PathVariable Long sampleId) {
        return sampleService.getSampleById(sampleId);
    }

    @GetMapping("/project/{projectId}")
    public List<Sample> getSampleByProjectId(@PathVariable Long projectId) {
        return sampleService.getSampleByProjectId(projectId);
    }

    @PostMapping("/{projectId}")
    public void registerSample(
            @PathVariable Long projectId,
            @RequestBody Sample sample) {
        sampleService.addNewSampleInProject(projectId, sample);
    }

    @DeleteMapping(path = "{sampleId}")
    public void deleteSample(@PathVariable("sampleId") Long sampleId) {
        sampleService.deleteSample(sampleId);
    }

    @PutMapping(path = "{sampleId}")
    public void updateSample(
            @PathVariable("sampleId") Long sampleId,
            @RequestParam(required = false) String nameSample,
            @RequestParam(required = false) LocalDate createDate
    ){
        sampleService.updateSample(sampleId, nameSample, createDate);
    }


}
