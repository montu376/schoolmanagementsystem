package com.school.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class StudentFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentFeeId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "fee_structure_id")
    private FeeStructure feeStructure;

    private Double totalFeeAmount;

    private Double paidAmount = 0.0;

    private Double pendingAmount;

    @Enumerated(EnumType.STRING)
    private FeePaymentStatus status; // PAID, PARTIAL, UNPAID

    private LocalDateTime lastUpdated;
    
    @OneToMany(mappedBy = "studentFee")
    private List<StudentPaymentTransaction> transactionList = new ArrayList<>();
    
    @JsonIgnore
	@ManyToOne
    @JoinColumn(name = "class_id")
    private SchoolClass className;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.lastUpdated = LocalDateTime.now();
    }
}


