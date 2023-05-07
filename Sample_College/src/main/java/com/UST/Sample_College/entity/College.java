package com.UST.Sample_College.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="collegeData")
public class College {
    @Id
    private Integer id;
    private String name;
    private String location;
    private String zipcode;
}
