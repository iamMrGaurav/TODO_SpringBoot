package com.example.todoproject.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int todoId;

    @NotNull(message = "Title cannot be null")
    @NotEmpty(message = "Title cannot be empty")
    @Column(updatable = true)
    private String title;

    @Column(updatable = true)
    private String description;

    @NotNull(message = "Date cannot be null")
    @NotEmpty(message = "Date cannot be empty")
    @Column(updatable = true)
    private ZonedDateTime date;

    @ManyToOne
    private User user;


}
