package com.example.demo.Exception;

public class PatientNotFoundException extends Exception {
	public PatientNotFoundException(long patientid) {
		super(String.format("Patiengt not found with id : '%s'", patientid));
	}

	private long patientid;
	

}
