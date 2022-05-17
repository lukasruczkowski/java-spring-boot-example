package com.example.usermanagement.user;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {

  private long id;
  private Date creationDate;
  private Date updateDate;
  private String email;
  private String firstName;
  private String lastName;

  public User() {}

  public User(String email, String firstName, String lastName) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format("User{id='{%d}'}", this.getId());
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, updatable = false, nullable = false)
  public long getId() {
    return id;
  }

  // Visible for testing.
  public void setId(long id) {
    this.id = id;
  }

  @Column(name = "creation_date", updatable = false, nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  @Column(name = "update_date", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  @Column(name = "email", nullable = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Column(name = "first_name", nullable = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name", nullable = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
