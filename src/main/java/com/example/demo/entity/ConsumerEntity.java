package com.example.demo.entity;

import java.util.Date;

import com.example.demo.dto.ConsumerDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="consumer")
public class ConsumerEntity {
	@Column(name="id")
	@Id
	private int id;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="dob")
	private String dob;
	@Column(name="mobile_number")
	private int mobileNo;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="state")
	private String state;
	@Column(name="district")
	private String district;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public ConsumerEntity(ConsumerDTO consumer) {
		this.id=consumer.getId();
		this.firstName = consumer.getFirstName();
		this.lastName = consumer.getLastName();
		this.dob = consumer.getDob();
		this.mobileNo = consumer.getMobileNo();
		this.email = consumer.getEmail();
		this.address = consumer.getAddress();
		this.state = consumer.getState();
		this.district = consumer.getDistrict();
	}
	public void updateExistingIfPresent(ConsumerDTO consumer) {
		if(!consumer.getFirstName().isEmpty())
			this.firstName=consumer.getFirstName();
		if(!consumer.getLastName().isEmpty())
			this.lastName=consumer.getLastName();
		if(consumer.getDob()!=null)
			this.dob=consumer.getDob();
		if(consumer.getMobileNo()==0)
			this.mobileNo=consumer.getMobileNo();
		if(!consumer.getEmail().isEmpty())
			this.email=consumer.getEmail();
		if(!consumer.getAddress().isEmpty())
			this.address=consumer.getAddress();
		if(!consumer.getState().isEmpty())
			this.state=consumer.getState();
		if(!consumer.getDistrict().isEmpty())
			this.district=consumer.getDistrict();
		
		
	}
	public ConsumerEntity() {
		super();
	}
	
}
