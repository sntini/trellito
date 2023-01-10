package com.sunny.trellito.task;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String details;
    private String status;
    private Long assignee;
    private Long sprintNumber;

}
