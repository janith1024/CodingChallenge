package com.jsa.controller;

import com.jsa.entity.Student;
import com.jsa.repository.AbstractRepository;
import com.jsa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Janith on 8/27/2017.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController extends AbstractController<Student> {

    @Autowired
    private StudentRepository repository;


    @Override
    protected AbstractRepository<Student> getRepository() {
        return repository;
    }
}
