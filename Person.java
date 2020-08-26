package com.info;

public class Person {

	String lastname;
	String city;
	String state;
	int zipcode;
	String phonenumber;
	String firstname;

	public Person(String firstname, String lastname, String city, String state, int zipcode, String phonenumber) {
		super();
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phonenumber = phonenumber;
		this.firstname = firstname;
	}

	@Override
	public String toString() {
		return "" + firstname + "" + lastname + "" + city + "" + state + "" + zipcode + "" + phonenumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}