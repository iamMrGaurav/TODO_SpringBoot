package com.example.todoproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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


}
