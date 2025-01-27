package com.healthcare.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "prescriptions")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AttributeOverride(name = "id",column = @Column(name="prescription_id"))
public class Prescription extends BaseEntity {
	
	@Column(name = "medicine_name",nullable = false)
	private String medicineName;
	@Column(nullable = false)
	private String dosage;
	@Column(name = "start_date",nullable = false)
	private LocalDate startDate;
	@Column(name = "end_date",nullable = false)
	private LocalDate endDate;
	private String notes;
	
	@JoinColumn(name = "patient_id",nullable = false,unique = true)
	private User patientId;
	@JoinColumn(name = "doctor_id",nullable = false,unique = true)
	private Doctor doctorId;
	
	@Override
    @Transient
    public LocalDateTime getUpdatedAt() {
        return null;
    }

    @Override
    @Transient
    public void setUpdatedAt(LocalDateTime updatedAt) {
    }
}
