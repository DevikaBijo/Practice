package com.example.SamplePratice.controller;


import com.example.SamplePratice.entity.Course;
import com.example.SamplePratice.entity.Student;
import com.example.SamplePratice.repository.CourseRepo;
import com.example.SamplePratice.repository.StudentRepo;
import com.example.SamplePratice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private CourseRepo courserepo;


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
  @PostMapping("/addcourse")
    public Course addAllcourse(@RequestBody Course course){
        return courserepo.save(course);
  }
  @GetMapping("/getcourse")
    public List<Course>getAllDetails(){
        return courserepo.findAll();
  }
  @GetMapping("/getcourse/{id}")
    public  Course getCourseById(@PathVariable Integer id){
        return courserepo.findById(id).orElse(null);
  }
  @DeleteMapping("/deletecourse/{id}")
    public String deleteCourseById(@PathVariable Integer id){
        courserepo.deleteById(id);
        return("The data is deleted");
  }
  @PutMapping("/putcourse")
    public Course updateById(@RequestBody Course course){
      Course old=null;
      Optional<Course>courses=courserepo.findById(course.getId());
      if(courses.isPresent()){
          old=courses.get();
          old.setCourseName(course.getCourseName());
          return courserepo.save(old);

      }else{
          return  new Course();
      }

  }


  }




