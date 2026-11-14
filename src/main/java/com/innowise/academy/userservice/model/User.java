package com.innowise.academy.userservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;

@Entity
@Table( name = "users")
public class User extends AuditableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column (name = "name", nullable = false, length = 100)
  private String name;

  @Column (name = "surname", nullable = false, length = 100)
    private String surname;

  @Column (name = "birth_date", nullable = false)
    private LocalDate birthDate;
  @Column( name = "email", nullable = false, length = 255)
    private String email;
  @Column (name = "active", nullable = false)
    private Boolean active = true;

  protected User() {}

    public User(String name, String surname, LocalDate birthDate, String email) {
      this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Long getId() {
    return id;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
      return surname;
    }
    public LocalDate getBirthDate() {
      return birthDate;
    }

    public boolean isActive() {
      return active;
    }

    public String getEmail() {
      return email;
    }
    public void setName(String name) {
      this.name = name;
    }

}
