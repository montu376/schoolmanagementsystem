package com.school.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required.")
    @Size(min = 4, max = 30, message = "Username must be between 4 and 30 characters.")
    private String username;
    
    @NotBlank(message = "Email is required.")
    @Email(message = "It must be a valid email format.")
    @Column(name="email", nullable = false, unique = true)
    private String email;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    @NotBlank(message = "Password is required.")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*]).{6,20}$",
        message = "Password must be 6–20 characters long and include at least one letter, one digit, and one special character."
    )
    private String password;
    
    @Enumerated(EnumType.STRING)
    private Role role;

    @NotBlank(message = "First name is required.")
    @Size(max = 50, message = "First name can be at most 50 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(max = 50, message = "Last name can be at most 50 characters.")
    private String lastName;

    @Column(name="mobile", unique = true, nullable = false)
    @NotBlank(message = "Mobile number is required.")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Mobile number must be a valid 10-digit Indian mobile number starting with 6-9."
    )
    private String mobileNumber;
    
    
    @Past(message = "Date of birth must be a past date.")
    @NotNull(message = "Date of birth is required.")
    private LocalDate dateOfBirth;
    
    @CreationTimestamp
    @Column(name = "register_date", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDateTime updatedAt;
    
    @JsonProperty(access = Access.WRITE_ONLY)
    private boolean isDeleted = false;

    @Enumerated(EnumType.STRING)
    private Status status;
}
