package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Appointment;
import com.example.demo.repository.AppointmentRepository;

@RestController
public class AppointmentController {
	
	Logger logger = LogManager.getLogger(AppointmentController.class);

	@Autowired
	AppointmentRepository appointmentRepository ;
	
	//Making an Appointment
		@PostMapping("/makeappointment")
		 public Appointment MakeAppointment(@Valid @RequestBody Appointment appointment) {
			
			logger.log(Level.INFO," Adding appointment for Patient");
		        return appointmentRepository.save(appointment);
		    }
		
		//Listing All Patients that have Made an Appointment In Ascending order of Date
		
			@PostMapping("/appointments")
			public List<Appointment> getAllPatientsWithAppointments(){
				logger.log(Level.INFO," Listing All Patients that have Made an Appointment");

				return appointmentRepository.findAll(sortByDate());
				
			}
			
			private Sort sortByDate() {
		        return new Sort(Sort.Direction.ASC, "date");
		    }
}
