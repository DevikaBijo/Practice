package com.example.SamplePratice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String courseName;
//    @ManyToMany(mappedBy = "courses" , fetch=FetchType.LAZY)
//    @JsonBackReference
//    private Set<Student> students;


}
