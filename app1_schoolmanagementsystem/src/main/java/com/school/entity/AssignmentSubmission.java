package com.school.entity;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentSubmission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer assignmentSubmissionId;

	private String submissionLink;

	private String documentUrl;

	@Column(name="submiited_at", updatable = false)
	private LocalDateTime submittedAt;

	private Double marks;

	private String feedback;

	@Enumerated(EnumType.STRING)
	private SubmissionStatus status;

	private Boolean late;

	@ManyToOne
	@JoinColumn(name = "assignment_id")
	private Assignment assignment;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;

}
