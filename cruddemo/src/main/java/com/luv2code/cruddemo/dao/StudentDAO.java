package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import java.util.List;

public interface StudentDAO {

    // CREATE
    void save(Student theStudent);

    // READ
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    // UPDATE
    void update(Student theStudent);

    // DELETE
    void delete(Integer id);
    int deleteAll();
}
