package com.example.cras.cras.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue
  private long id;
  private String username;
  private String email;
  private String userType;
  private String MatricNo;

  public User() {
  }

  public User(long id, String username, String email, String userType, String matricNo) {
    super();
    this.id = id;
    this.username = username;
    this.email = email;
    this.userType = userType;
    MatricNo = matricNo;
  }

  public User(String username, String email, String userType, String matricNo) {
    super();
    this.username = username;
    this.email = email;
    this.userType = userType;
    MatricNo = matricNo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getMatricNo() {
    return MatricNo;
  }

  public void setMatricNo(String matricNo) {
    MatricNo = matricNo;
  }

}
