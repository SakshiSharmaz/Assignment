package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.model.Constraints.ContactNumberConstraint;
import com.example.demo.model.Constraints.ValidPassword;

@Entity
@Table(name="Patient")
public class Patient {
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Patient() {
		super();
	}

	public Patient(int id, @NotBlank @Size(min = 3) String name, @NotBlank @Size(min = 10) String address,
			@NotBlank @Size(min = 3) @javax.validation.constraints.Email String email, @NotBlank Long phoneNumber,
			@NotBlank @Size(min = 3) String password) {
		super();
		this.id = id;
		Name = name;
		Address = address;
		Email = email;
		PhoneNumber = phoneNumber;
		Password = password;
	}

	@Id
	@GeneratedValue
	int id;
	
	@NotBlank
	@Size(min=3)
	String Name;
	
	@NotBlank
	@Size(min=10)
	String Address;
	
	@NotBlank
	@Size(min=3)
	@javax.validation.constraints.Email
	String Email;
	
	@NotBlank
	@ContactNumberConstraint
	Long PhoneNumber;
	
	@NotBlank
	@Size(min=3)
	@ValidPassword
	String Password;
	

}
