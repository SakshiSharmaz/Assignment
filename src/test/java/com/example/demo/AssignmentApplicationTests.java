package com.example.demo;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.PatientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AssignmentApplicationTests {

	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private AppointmentRepository appointmentRepo;
	@Test
	public void contextLoads() {
	}
	
	public void persistanceWorksPatient() {
		assertThat(patientRepo.findAll(),not(Matchers.emptyIterable()));
		
	}
	public void persistanceWorksAppointment() {
		assertThat(appointmentRepo.findAll(),not(Matchers.emptyIterable()));
		
	}
	
	

}
