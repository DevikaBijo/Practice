package com.example.SamplePratice.controller;


import com.example.SamplePratice.entity.Student;
import com.example.SamplePratice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public Student addalldetails(@RequestBody Student student)
    {
        return studentService.addalldetails(student);
    }
    @GetMapping("/getall")
    public List<Student> getalldetails(){
        return studentService.getalldetails();
    }
    @GetMapping("/getall/{id}")
    public Student getallById(@PathVariable Integer id){
        return studentService.getallById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
            return studentService.deleteById(id);
    }
    @PutMapping("/put")
    public Student updateById(@RequestBody Student student){
        return studentService.updateById(student);
    }



}
