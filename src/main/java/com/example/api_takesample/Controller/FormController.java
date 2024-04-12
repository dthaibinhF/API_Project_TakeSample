package com.example.api_takesample.Controller;

import com.example.api_takesample.Model.Form;
import com.example.api_takesample.Model.Picture;
import com.example.api_takesample.Service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/form")
public class FormController {

    FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping
    public List<Form> getForm() {
        return formService.getForm();
    }

    @GetMapping("{formId}")
    public List<Form> getFormById(@PathVariable Long formId) {
        return formService.getFormById(formId);
    }

    @GetMapping("/sample/{sampleId}")
    public List<Form> getFormBySampleId(@PathVariable Long sampleId) {
        return formService.getPictureBySampleId(sampleId);
    }

    @PostMapping("{sampleId}")
    public void registerFormInSample(
            @PathVariable Long sampleId,
            @RequestBody Form form) {
        formService.addNewFormInSample(sampleId, form);
    }

    @DeleteMapping(path = "{formId}")
    public void deleteForm(@PathVariable("formId") Long formId) {
        formService.deleteForm(formId);
    }

    @PutMapping(path = "{formId}")
    public void updateTask(
            @PathVariable("formId") Long formId,
            @RequestParam(required = false) String nameForm,
            @RequestParam(required = false) LocalDate createDate,
            @RequestParam(required = false) String url
    ){
        formService.updateForm(formId, nameForm, createDate, url);
    }


}
