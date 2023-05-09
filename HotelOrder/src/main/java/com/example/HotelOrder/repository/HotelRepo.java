package com.example.HotelOrder.repository;

import com.example.HotelOrder.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo  extends JpaRepository<Hotel,Integer> {
}
