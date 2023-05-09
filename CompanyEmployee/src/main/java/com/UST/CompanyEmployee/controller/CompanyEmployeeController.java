package com.UST.CompanyEmployee.controller;

import com.UST.CompanyEmployee.CompanyEmployeeApplication;
import com.UST.CompanyEmployee.Exception.IDNotFoundException;
import com.UST.CompanyEmployee.entity.Company;
import com.UST.CompanyEmployee.entity.Employee;
import com.UST.CompanyEmployee.repository.CompanyRepo;
import com.UST.CompanyEmployee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CompanyEmployeeController {
    @Autowired
    private CompanyRepo companyrepo;
    @Autowired
    private EmployeeRepo employeerepo;
    @PostMapping("/addcompany")
    public ResponseEntity<Company>createCompany(@RequestBody Company company){
        return ResponseEntity.ok().body(companyrepo.save(company));
    }
    @PostMapping("/addemployee")
    public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(employeerepo.save(employee));
    }
    @GetMapping("/getcompany")
    public ResponseEntity<List<Company>>getallCompany(){
        return ResponseEntity.ok().body(companyrepo.findAll());
    }
    @GetMapping("/getemployee")
    public ResponseEntity<List<Employee>>getallEmployee(){
        return ResponseEntity.ok().body(employeerepo.findAll());
    }
    @GetMapping("/getcompany/{id}")
    public ResponseEntity<Company>getBycompanyId(@PathVariable Integer id) throws IDNotFoundException{
        Optional<Company>C=companyrepo.findById(id);
        if(C.isPresent()) {
            return ResponseEntity.ok().body(companyrepo.findById(id).orElse(null));
        }else{
            throw new IDNotFoundException("company Id is not found");
//            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/getcompanyname/{companyName}")
    public ResponseEntity<Company>getBycompanyName(@PathVariable String companyName){
        return ResponseEntity.ok().body(companyrepo.findBycompanyName(companyName));
    }


    @GetMapping("/getemployee/{id}")
    public ResponseEntity<Employee>getByemployeeId(@PathVariable Integer id){
        return ResponseEntity.ok().body(employeerepo.findById(id).orElse(null));
    }
    @DeleteMapping("/deletecompany/{id}")
    public ResponseEntity<String>deleteBycompanyId(@PathVariable Integer id){
        companyrepo.deleteById(id);
        return ResponseEntity.ok().body("deleted companyid:");
    }
    @DeleteMapping("/deleteemployee/{id}")
    public ResponseEntity<String>deleteByemployeeId(@PathVariable Integer id){
        employeerepo.deleteById(id);
        return ResponseEntity.ok().body("deleted employeeid:");
    }
    @PutMapping("/updatecompany/{id}")
    public ResponseEntity<Company>updateBycompanyId(@RequestBody Company company ,@PathVariable Integer id){
        Company old= null;
        Optional<Company>c=companyrepo.findById(id);
        old= c.get();
        old.setId(id);
        old.setCompanyName(company.getCompanyName());
        return ResponseEntity.ok().body(companyrepo.save(old));

    }
    @PutMapping("/updateemployee/{id}")
    public ResponseEntity<Employee>updateByemployeeId(@RequestBody Employee employee, @PathVariable Integer id){
        Employee old=null;
        Optional<Employee>e=employeerepo.findById(id);
        old=e.get();
        old.setId(id);
        old.setEmployeeName(employee.getEmployeeName());
        return ResponseEntity.ok().body(employeerepo.save(old));
    }

}
