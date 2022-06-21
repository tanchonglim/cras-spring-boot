package com.example.cras.cras.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

  public Optional<College> getCollegeById(long id) {
    return collegeRepository.findById(id);
  }

  public void addNewCollege(College college) {
    collegeRepository.save(college);
  }

  public boolean updateCollege(long id, College college) {
    Optional<College> optionalCurrentCollege = collegeRepository.findById(id);
    if (!optionalCurrentCollege.isPresent())
      return false;

    College currentCollege = optionalCurrentCollege.get();
    currentCollege.setAddress(college.getAddress());
    currentCollege.setCollegeName(college.getCollegeName());
    currentCollege.setTotalAvailable(college.getTotalAvailable());
    collegeRepository.save(currentCollege);
    return true;
  }

  public boolean deleteCollege(long id) {
    Optional<College> optionalCurrentCollege = collegeRepository.findById(id);
    if (!optionalCurrentCollege.isPresent())
      return false;

    collegeRepository.delete(optionalCurrentCollege.get());
    return true;
  }

}
