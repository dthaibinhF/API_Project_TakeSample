package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormRepository  extends JpaRepository<Form, Long> {
    List<Form> findFormByIdForm(Long formId);
    List<Form> findFormBySampleIdSample(Long sampleId);

}
