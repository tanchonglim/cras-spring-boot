package com.example.cras.cras.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private long id;
  private String name;
  private String matricNo;
  private String imagePath;
  private long application;
  

  public Student() {
  }

  public Student(long id, String name, String matricNo, String imagePath, long application) {
    super();
    this.id = id;
    this.name = name;
    this.matricNo = matricNo;
    this.imagePath = imagePath;
    this.application = application;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMatricNo() {
    return matricNo;
  }

  public void setMatricNo(String matricNo) {
    this.matricNo = matricNo;
  }

  public String getImagePath() {
    return imagePath;
  }

  public void setImagePath(String imagePath) {
    this.imagePath = imagePath;
  }

  public long getApplication() {
    return application;
  }

  public void setApplication(long application) {
    this.application = application;
  }
}
