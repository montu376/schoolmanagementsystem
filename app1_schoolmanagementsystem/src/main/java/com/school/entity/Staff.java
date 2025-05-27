package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "staff_id")
public class Staff extends User {

    private String designation; 
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private String workShift; 

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType; 
    
    @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
