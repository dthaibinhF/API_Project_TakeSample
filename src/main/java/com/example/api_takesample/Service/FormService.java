package com.example.api_takesample.Service;

import com.example.api_takesample.Model.Form;
import com.example.api_takesample.Repository.FormRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }


    public List<Form> getForm() {
        return formRepository.findAll();
    }

    public void addNewForm(Form form) {
        Optional<Form> optionalForm = formRepository
                .findById(form.getIdForm());

        if (optionalForm.isPresent())
            throw new IllegalStateException(
                    "Form id have taken"
            );
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
}
