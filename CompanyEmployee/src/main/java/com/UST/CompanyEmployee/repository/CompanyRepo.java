package com.UST.CompanyEmployee.repository;

import com.UST.CompanyEmployee.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo  extends JpaRepository<Company, Integer> {


    Company findBycompanyName(String companyName);
}
