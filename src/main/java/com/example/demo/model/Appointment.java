package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Appointment")
public class Appointment {

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient patient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Appointment() {
		super();
	}

	public Appointment(Date date, Patient patient) {
		super();
		this.date = date;
		this.patient=patient;
	}

	@NotBlank
	Date date;
	
	@NotBlank
	Patient patient;
	
}
