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

import com.example.cras.cras.Models.Application;
import com.example.cras.cras.Services.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    
  @Autowired
  private final ApplicationService applicationService;

  public ApplicationController(ApplicationService applicationService) {
    this.applicationService = applicationService;
  }

  @GetMapping
  public List<Application> getAllApplications() {
    return applicationService.getAllApplications();
  }

  @PutMapping(path = "{id}")
  public void updateApprovalApplication(@PathVariable("id") long id, @RequestBody(required = true) Application application) {
    boolean isSuccess = applicationService.updateApprovalApplication(id, application);
    if (!isSuccess)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
  }
}
