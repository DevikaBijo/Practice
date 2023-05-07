package com.UST.StudentDepartment.controller;
import com.UST.StudentDepartment.entity.Department;
import com.UST.StudentDepartment.entity.Student;
import com.UST.StudentDepartment.repository.DepartmentRepo;
import com.UST.StudentDepartment.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentDeptController {
    @Autowired
    private StudentRepo studentrepo;
    @Autowired
    private DepartmentRepo deptrepo;
    @PostMapping("/addstudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok().body(studentrepo.save(student));
    }
    @PostMapping("/addDept")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        return ResponseEntity.ok().body(deptrepo.save(department));
    }
    @GetMapping("/getstudent")
    public ResponseEntity<List<Student>> getallStudent(){
        return ResponseEntity.ok().body(studentrepo.findAll());

    }
    @GetMapping("/getDept")
    public ResponseEntity<List<Department>>getallDept(){
        return ResponseEntity.ok().body(deptrepo.findAll());
    }
    @GetMapping("getstudent/{id}")
    public ResponseEntity<Student>getByStudentId(@PathVariable Integer id){
        Optional<Student>s=studentrepo.findById(id);
        if(s.isPresent()) {
            return ResponseEntity.ok().body(studentrepo.findById(id).orElse(null));
        }else{
            return ResponseEntity.noContent().build();
        }

    }
    @GetMapping("getDept/{id}")
    public ResponseEntity<Department>getByDeptId(@PathVariable Integer id){
        return ResponseEntity.ok().body(deptrepo.findById(id).orElse(null));
    }
    @DeleteMapping("deletestudent/{id}")
    public ResponseEntity<String>deletebystudentId(@PathVariable Integer id) {
        studentrepo.deleteById(id);
        return ResponseEntity.ok().body("deleted studentid");
    }
    @DeleteMapping("/deletedept/{id}")
    public ResponseEntity<String>deletebydeptid(@PathVariable Integer id){
        deptrepo.deleteById(id);
        return ResponseEntity.ok().body("deleted dept id");
    }
    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student>updatebyStudentid(@RequestBody Student student, @PathVariable Integer id){
        Student old=null;
        Optional<Student>s=studentrepo.findById(id);
        if(s.isPresent()) {
            old = s.get();
            old.setId(id);
            old.setStudentName(student.getStudentName());
            return ResponseEntity.ok().body(studentrepo.save(old));
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @PutMapping("/updatedept/{id}")
    public ResponseEntity<Department>updatebydeptid(@RequestBody Department department, @PathVariable Integer id) {
        Department old = null;
        Optional<Department> D = deptrepo.findById(id);
        if (D.isPresent()) {
            old = D.get();
            old.setId(id);
            old.setDeptName(department.getDeptName());
            return ResponseEntity.ok().body(deptrepo.save(old));
        }else{
            return ResponseEntity.noContent().build();
        }
    }
}
