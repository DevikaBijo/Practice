package com.example.SamplePratice.repository;

import com.example.SamplePratice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {


    Optional<Student> findByName(String name);
}
