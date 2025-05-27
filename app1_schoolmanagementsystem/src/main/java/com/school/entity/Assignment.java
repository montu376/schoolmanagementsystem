package com.school.entity;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Assignment {
	
	@Id
	private Integer assignmentId;
	
	private String title;
	
	private String description;
	
	private LocalDateTime schedule;
	
	private LocalDateTime conclude;
	
	private String documentUrl;
	
	@ManyToOne
	@JoinColumn(name="section_id")
	private Section section;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@OneToMany(mappedBy = "assignment")
	private Set<AssignmentSubmission> submisisons = new LinkedHashSet<>();

}
