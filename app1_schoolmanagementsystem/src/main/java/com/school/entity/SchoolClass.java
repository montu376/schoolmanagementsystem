package com.school.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer classId;
	
	private String className;
	
	@JsonIgnore
	@OneToMany(mappedBy = "className")
	private Set<Section> sectionList = new LinkedHashSet<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="class_subjects", joinColumns = @JoinColumn(name="class_id"),
	inverseJoinColumns = @JoinColumn(name="subject_id"))
	private Set<Subject> subjectList = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "schoolClass")
	private FeeStructure feeStructure;
	
	@JsonIgnore
	@OneToMany(mappedBy = "className")
	private Set<Exam> exams = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "className")
	private Set<Result> results = new LinkedHashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "className")
	private Set<StudentFee> feeRecords = new LinkedHashSet<>();
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
	
}
