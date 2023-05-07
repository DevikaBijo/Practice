package com.UST.Sample_College.service;

import com.UST.Sample_College.Exception.IDNotFoundException;
import com.UST.Sample_College.entity.College;
import com.UST.Sample_College.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private CollegeRepo repo;
    public College addAllDetails(College college) {
        return repo.save(college);
    }

    public List<College> getAllDetails() {
        return repo.findAll();
    }

    public College getAllById(Integer id) {
        Optional<College> c = repo.findById(id);
        if (c.isEmpty()) {
            throw new IDNotFoundException("id:" + id + "not found");
        } else {
          return  c.get();
        }

//        return repo.findById(id).orElse(null);
    }

    public String deleteById(Integer id) {
        repo.deleteById(id);
        return "deleted";
    }

    public College updateById(College college) {
        College old= null;
        Optional<College> clg= repo.findById(college.getId());
                if(clg.isPresent()){
                    old=clg.get();
                    old.setId(college.getId());
                    old.setName(college.getName());
                    old.setLocation(college.getLocation());
                    old.setZipcode(college.getZipcode());
                    return repo.save(old);
                }
                else{
                    return new College();
                }
    }
}
