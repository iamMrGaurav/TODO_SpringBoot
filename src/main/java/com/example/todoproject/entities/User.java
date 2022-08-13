package com.example.todoproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @NotEmpty(message = "First Name cannot be Empty")
    @NotNull(message = "First Name cannot be Null")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be Empty")
    @NotNull(message = "Last Name cannot be Null")
    private String lastName;

    @Column(unique = true, updatable = false)
    @NotEmpty(message = "User Name cannot be Empty")
    @NotNull(message = "Username cannot be Null")
    private String userName;

    @Column(unique = true)
    @NotEmpty(message = "Email cannot be Empty")
    @NotNull(message = "Email cannot be Null")
    @Email(message = "Invalid Email.")
    private String email;

    @NotEmpty(message = "Password cannot be Empty")
    @NotNull(message = "Password cannot be Null")
    private String password;

    @NotNull(message = "DOB Can't be null")
    private LocalDate dob;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
