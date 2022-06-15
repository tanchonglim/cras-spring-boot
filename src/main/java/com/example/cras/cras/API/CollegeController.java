package com.example.cras.cras.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cras.cras.Models.College;
import com.example.cras.cras.Services.CollegeService;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

  @Autowired
  private final CollegeService collegeService;

  public CollegeController(CollegeService collegeService) {
    this.collegeService = collegeService;
  }

  @GetMapping
  public List<College> getAllColleges() {
    return collegeService.getAllColleges();
  }
}
