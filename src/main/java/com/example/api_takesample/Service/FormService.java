package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Form;
import com.example.api_takesample.Model.Sample;
import com.example.api_takesample.Repository.FormRepository;
import com.example.api_takesample.Repository.SampleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    FormRepository formRepository;
    SampleRepository sampleRepository;

    public FormService(FormRepository formRepository, SampleRepository sampleRepository) {
        this.formRepository = formRepository;
        this.sampleRepository = sampleRepository;
    }

    public List<Form> getForm() {
        return formRepository.findAll();
    }

    public void addNewFormInSample(Long sampleId, Form form) {
        boolean isSampleExist = sampleRepository.existsById(sampleId);
        if (!isSampleExist) throw new IllegalStateException(
                "Sample with id " + sampleId + " does not exits"
        );

        Optional<Form> optionalPicture = formRepository.findById(form.getIdForm());

        if (optionalPicture.isPresent()) throw new IllegalStateException(
                "Picture id have taken"
        );

        Optional<Sample> sampleOptional = sampleRepository
                .findById(sampleId);

        form.setSample(sampleOptional.get());
        formRepository.save(form);
    }


    public void deleteForm(Long formId) {
        boolean exist = formRepository
                .existsById(formId);

        if (!exist)
            throw new IllegalStateException(
                    "form with id " + formId + " does not exist"
            );

        formRepository.deleteById(formId);
    }

    @Transactional
    public void updateForm(Long formId, String nameForm, LocalDate createDate, String url) {
        Form form = formRepository.findById(formId).orElseThrow(
            () -> new IllegalStateException(
                "Form with id " + formId + "does not exist"
            )
        );

        if (nameForm != null &&
                !nameForm.equals(form.getNameForm())) {
            form.setNameForm(nameForm);
        }

        if (createDate != null &&
                !createDate.equals(form.getCreateDate())) {
            form.setCreateDate(createDate);
        }

        if (url != null &&
                !url.equals(form.getUrl())) {
            form.setUrl(url);
        }
    }

    public List<Form> getFormById(Long formId) {
        boolean exist = formRepository.existsById(formId);

        if (!exist) throw new IllegalStateException(
                "Form with id " + formId + " does not exist"
        );
        return formRepository.findFormByIdForm(formId);
    }

    public List<Form> getPictureBySampleId(Long sampleId) {
        return formRepository.findFormBySampleIdSample(sampleId);
    }
}
