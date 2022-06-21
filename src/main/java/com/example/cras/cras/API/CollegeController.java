package com.example.cras.cras.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

  @GetMapping(path = "{id}")
  public College getCollege(@PathVariable("id") long id) {
    Optional<College> optionalCollege = collegeService.getCollegeById(id);
    if (!optionalCollege.isPresent())
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found");
    return optionalCollege.get();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public void addNewCollege(@RequestBody(required = true) College college) {
    collegeService.addNewCollege(college);
  }

  @PutMapping(path = "{id}")
  public void updateCollege(@PathVariable("id") long id, @RequestBody(required = true) College college) {
    boolean isSuccess = collegeService.updateCollege(id, college);
    if (!isSuccess)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found");
  }

  @DeleteMapping(path = "{id}")
  public void deleteCollege(@PathVariable("id") long id) {
    boolean isSuccess = collegeService.deleteCollege(id);
    if (!isSuccess)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "College not found");
  }
}
