package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.PatientNotFoundException;
import com.example.demo.model.Appointment;
import com.example.demo.model.Patient;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PatientRepository;

@RestController
public class PatientController {
	Logger logger  = LogManager.getLogger(PatientController.class);
	@Autowired
	PatientRepository patientRepository;
	
	//Adding a patient record
	@PostMapping("/patient")
    public Patient createPatientRecord(@Valid @RequestBody Patient patient) {
		logger.log(Level.INFO,"Adding a patient record");

        return patientRepository.save(patient);
    }
	
	// Updating an existing patient record
	@PutMapping("/patient/{id}")
    public Patient updatePatientRecord(@PathVariable(value = "id") Long patientid,
                           @Valid @RequestBody Patient patientDetails) throws PatientNotFoundException {

Patient patient = patientRepository.findById(patientid)
                .orElseThrow(() -> new PatientNotFoundException(patientid));

patient.setName(patientDetails.getName());
        patient.setAddress(patientDetails.getAddress());
        patient.setEmail(patientDetails.getEmail());

Patient updatedPatient = patientRepository.save(patient);
logger.log(Level.INFO,"Updating an existing patient record");


return updatedPatient;
    }
	
	//Deleting a patient record
	 @DeleteMapping("/patient/{id}")
	    public ResponseEntity<?> deletePatientRecord(@PathVariable(value = "id") Long patientid) throws PatientNotFoundException {
	        Patient patient = patientRepository.findById(patientid)
	                .orElseThrow(() -> new PatientNotFoundException(patientid));

	patientRepository.delete(patient);
	logger.log(Level.INFO,"Deleting a patient record");

	return ResponseEntity.ok().build();
	    }
	
	 // Fetching all the patient records in an order
	@GetMapping("/patient")
			public List<Patient> getAllPatients(){
		logger.log(Level.INFO,"Fetching all the patient records in an order");

		return patientRepository.findAll(sortByIdAsc());
		
	}
	
	private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }
	
	
	
	 
	 
	
	

}
