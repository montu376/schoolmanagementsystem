package com.school.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "teacher_id")
public class Teacher extends User {
	
	@Column(unique = true, nullable = false)
	private String teacherCode;

    @NotBlank(message = "Qualification is required.")
    @Size(min = 2, max = 100, message = "Qualification should be between 2 and 100 characters.")
    private String qualification;

    @NotBlank(message = "Specialization is required.")
    @Size(min = 2, max = 100, message = "Specialization should be between 2 and 100 characters.")
    private String specialization;

    @NotNull(message = "Date of joining is required.")
    @PastOrPresent(message = "Date of joining cannot be in the future.")
    private LocalDate dateOfJoining;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Alternate mobile number must be a valid 10-digit Indian number.")
    private String alternateMobile;

    @NotNull(message = "Employment type is required.")
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    @Valid
    @Embedded
    private Address address;

    @JsonIgnore
    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private Set<Section> assignedSections = new HashSet<>();

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
