package com.example.cras.cras.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cras.cras.Models.College;
import com.example.cras.cras.Models.CollegeRepository;

@Service
public class CollegeService {

  @Autowired
  private final CollegeRepository collegeRepository;

  public CollegeService(CollegeRepository collegeRepository) {
    this.collegeRepository = collegeRepository;
  }

  public List<College> getAllColleges() {
    Iterable<College> source = collegeRepository.findAll();
    List<College> target = new ArrayList<College>();
    source.forEach(target::add);
    return target;
  }

  public boolean addNewCollege(College college) {
    try {
      collegeRepository.save(college);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
