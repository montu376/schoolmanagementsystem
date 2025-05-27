package com.school.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private Integer schoolId;
	
	@NotBlank(message="schoolName field Can't be blank")
	@Column(name="school_name", nullable = false, unique = true, length = 100)
	private String schoolName;
	
	@Embedded
	private Address address;
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Student> studentList = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<SchoolClass> classList = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Teacher> teacherList = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Staff> staffList = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<FeeStructure> feeStructures = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Department> departments = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private Set<Announcement> announcements = new LinkedHashSet<>();
	
}
