package com.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double totalFeeAmount;

    @Enumerated(EnumType.STRING)
    private FeeFrequency frequency; // MONTHLY, QUARTERLY, etc.

    private String feeDescription;

    @OneToOne
    @JoinColumn(name = "class_id")
    private SchoolClass schoolClass; // or simply `Class` if you use a different name
    
    @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}

