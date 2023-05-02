package com.example.SamplePratice.service;

import com.example.SamplePratice.entity.Student;
import com.example.SamplePratice.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public Student addalldetails(Student student) {
        return repo.save(student);
    }

    public List<Student> getalldetails() {
        return repo.findAll();
    }

    public Student getallById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public String deleteById(Integer id) {
        return "deleted";
    }

    public Student updateById(Student student) {
        Student old = null;
        Optional<Student> students = repo.findById(student.getId());
        if (students.isPresent()) {
            old = students.get();
            old.setName(student.getName());
            old.setRollNo(student.getRollNo());
            old.setEmail(student.getEmail());
            repo.save(old);

    }else{
        return new Student();
    }
    return old;

}
}
