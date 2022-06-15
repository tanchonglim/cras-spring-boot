package com.example.cras.cras.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class College {

  @Id
  @GeneratedValue
  private long id;
  private String collegeName;
  private String address;
  private Date addedDate;
  private Integer totalAvailable;

  public College() {
  }

  public College(String collegeName, String address, Integer totalAvailable) {
    super();
    this.collegeName = collegeName;
    this.address = address;
    this.addedDate = new Date();
    this.totalAvailable = totalAvailable;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCollegeName() {
    return collegeName;
  }

  public void setCollegeName(String collegeName) {
    this.collegeName = collegeName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getAddedDate() {
    return addedDate;
  }

  public void setAddedDate(Date addedDate) {
    this.addedDate = addedDate;
  }

  public Integer getTotalAvailable() {
    return totalAvailable;
  }

  public void setTotalAvailable(Integer totalAvailable) {
    this.totalAvailable = totalAvailable;
  }

}
