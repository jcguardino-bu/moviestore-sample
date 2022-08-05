package com.moviestore.domain;

public class Person {

	protected String firstName;
	protected String lastName;

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

	public String toString() {
		return String.format("%s %s", this.getFirstName(), this.getLastName());
	}

}
