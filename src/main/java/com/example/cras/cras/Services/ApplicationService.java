package com.example.cras.cras.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cras.cras.Models.Application;
import com.example.cras.cras.Models.ApplicationRepository;

import com.example.cras.cras.Models.Room;
import com.example.cras.cras.Models.RoomRepository;

import com.example.cras.cras.Models.Student;
import com.example.cras.cras.Models.StudentRepository;

@Service
public class ApplicationService {

  @Autowired
  private final ApplicationRepository applicationRepository;

  @Autowired
  private final RoomRepository roomRepository;

  @Autowired
  private final StudentRepository studentRepository;

  public ApplicationService(ApplicationRepository applicationRepository, RoomRepository roomRepository, StudentRepository studentRepository) {
    this.applicationRepository = applicationRepository;
    this.roomRepository = roomRepository;
    this.studentRepository = studentRepository;
  }

  public List<Application> getAllApplications() {
    Iterable<Application> source = applicationRepository.findAll();
    List<Application> target = new ArrayList<Application>();
    source.forEach(target::add);
    return target;
  }

  public void addApplication(Application application) {
    applicationRepository.save(application);
  }

  public boolean updateApprovalApplication(long id, Application application) {
    Optional<Application> optionalCurrentApplication = applicationRepository.findById(id);
    if (!optionalCurrentApplication.isPresent())
      return false;

    Application currentApplication = optionalCurrentApplication.get();
    currentApplication.setStatus(application.getStatus());
    currentApplication.setProcessedDate(new Timestamp(System.currentTimeMillis()));
    applicationRepository.save(currentApplication);

    if ((application.getStatus() != "approved") && (application.getStatus() != "pending")) {
      Optional<Room> optionalCurrentRoom = roomRepository.findById(application.getRoomId());

      Room currentRoom = optionalCurrentRoom.get();
      currentRoom.setOccupied(currentRoom.getOccupied() - 1);
      roomRepository.save(currentRoom);

      Optional<Student> optionalCurrentStudent = studentRepository.findById(application.getStudentId());

      Student currentStudent = optionalCurrentStudent.get();
      currentStudent.setApplication(0);
      studentRepository.save(currentStudent);
    }
    return true;
  }
}
