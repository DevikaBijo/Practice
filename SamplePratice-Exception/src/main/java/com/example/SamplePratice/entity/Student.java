package com.example.SamplePratice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="studentexp")
public class Student {
    @Id
    @Column(name="ID")
    private int id;
    @NotBlank(message = "the column name should not be blank")
    @Column(name="NAME")
    private String name;
    @Column(name="ROLLNO")
    private String rollNo;
    @Column(name="EMAIL")
    private String email;

}
