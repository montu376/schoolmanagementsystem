package com.school.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sectionId;
	
	@Enumerated(EnumType.STRING)
	private SectionType type;
	
	@ManyToOne
	@JoinColumn(name="class_id")
	private SchoolClass className;
	
	@ManyToMany
	@JoinTable(name="section_teacher", joinColumns = @JoinColumn(name="section_id"), 
	inverseJoinColumns = @JoinColumn(name="teacher_id"))
	private Set<Teacher> teachers = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "section")
	private Set<ClassSchedule> classScheduleList = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "section")
	private Set<Student> studentList = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "section")
	private Set<Assignment> assignmentList = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "section")
	private Set<Test> quizeList = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "section")
	private Set<Attendance> attendances = new LinkedHashSet<>();
	
}
