package com.darshan.My1stproject.controller;

import com.darshan.My1stproject.model.Student;
import com.darshan.My1stproject.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")// allows fortend access
public class StudentController{
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping // get all students
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    //Add new Student by Id
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);

    }
    @PutMapping ("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        return studentRepository.save(student);

    }
    //Delete student by Id
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentRepository.deleteById(id);
    }




}
