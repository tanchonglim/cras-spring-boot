package com.example.cras.cras.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {
    
  @Id
  @GeneratedValue
  private long id;
  private String roomName;
  private long collegeId;
  private Date addedDate;
  private String roomType;
  private long activated;
  private long capacity;
  private long occupied;

  public Room(){
  }

  public Room(long id, String roomName, long collegeId, Date addedDate, String roomType, long activated, long capacity, long occupied) {
    super();
    this.id = id;
    this.roomName = roomName;
    this.collegeId = collegeId;
    this.addedDate = addedDate;
    this.roomType = roomType;
    this.activated = activated;
    this.capacity = capacity;
    this.occupied = occupied;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getRoomName() {
    return roomName;
  }

  public void setRoomName(String roomName) {
    this.roomName = roomName;
  }

  public long getCollegeId() {
    return collegeId;
  }

  public void setCollegeId(long collegeId) {
    this.collegeId = collegeId;
  }

  public Date getAddedDate() {
    return addedDate;
  }

  public void setAddedDate(Date addedDate) {
    this.addedDate = addedDate;
  }

  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }

  public long getActivated() {
    return activated;
  }

  public void setActivated(Long activated) {
    this.activated = activated;
  }

  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(Long capacity) {
    this.capacity = capacity;
  }

  public long getOccupied() {
    return occupied;
  }

  public void setOccupied(Long occupied) {
    this.occupied = occupied;
  }
}
