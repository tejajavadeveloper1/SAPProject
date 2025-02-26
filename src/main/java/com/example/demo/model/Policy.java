 package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "policies")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Policy name cannot be blank.")
    private String name;

    @Version
    private Integer version=0; // Add this field for optimistic locking

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getVersion() { return version; }
    public void setVersion(Integer version) { this.version = version; }
}
