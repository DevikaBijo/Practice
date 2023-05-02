package com.example.SamplePratice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
