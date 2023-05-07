package com.UST.Sample_College.controller;

import com.UST.Sample_College.entity.College;
import com.UST.Sample_College.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {
    @Autowired
    private CollegeService service;
    @PostMapping("/add")
    public College addAllDetails(@RequestBody College college){
        return service.addAllDetails(college);
    }
    @GetMapping("/getall")
    public List<College>getAllDetails(){
        return service.getAllDetails();
    }
    @GetMapping("/getall/{id}")
    public College getAllById(@PathVariable Integer id) {
        return service.getAllById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        return service.deleteById(id);
    }
    @PutMapping("/update")
    public College updateById(@RequestBody College college){
        return service.updateById(college);
    }
}
