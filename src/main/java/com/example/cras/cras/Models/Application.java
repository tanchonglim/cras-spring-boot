package com.example.cras.cras.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {
    
  @Id
  @GeneratedValue
  private long id;
  private Date applicationDate;
  private Date processedDate;
  private long studentId;
  private long roomId;
  private String status;

  public Application(){
  }

  public Application(long id, Date applicationDate, Date processedDate, long studentId, long roomId, String status) {
    super();
    this.id = id;
    this.applicationDate = applicationDate;
    this.processedDate = processedDate;
    this.studentId = studentId;
    this.roomId = roomId;
    this.status = status;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public Date getProcessedDate() {
    return processedDate;
  }

  public void setProcessedDate(Date processedDate) {
    this.processedDate = processedDate;
  }

  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

  public long getRoomId() {
    return roomId;
  }

  public void setRoomId(long roomId) {
    this.roomId = roomId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
