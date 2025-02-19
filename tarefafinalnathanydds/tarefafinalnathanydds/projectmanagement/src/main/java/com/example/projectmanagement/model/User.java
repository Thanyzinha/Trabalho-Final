package com.example.projectmanagement.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String responsibility;
    private String firm;

    // Getters e Setters
}
