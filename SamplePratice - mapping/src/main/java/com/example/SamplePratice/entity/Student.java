package com.example.SamplePratice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student")
public class Student {
    @Id
    private int id;
    private String name;
    private String rollNo;
    private String email;

//    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinTable(name="student_course_table",
//                joinColumns={@JoinColumn(name="student_id", referencedColumnName = "id")},
//                         inverseJoinColumns = {@JoinColumn(name="course_id", referencedColumnName = "id")})
//    @JsonBackReference
//    private Set<Course>courses;



}
