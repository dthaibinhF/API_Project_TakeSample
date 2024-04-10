package com.example.api_takesample.Repository;

import com.example.api_takesample.Model.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository  extends JpaRepository<Form, Long> {

}
