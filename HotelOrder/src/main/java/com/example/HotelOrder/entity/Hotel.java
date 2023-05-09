package com.example.HotelOrder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Hotel")
public class Hotel {
    @Id
    @GeneratedValue
    private Integer id;
    private String hotelName;
}
