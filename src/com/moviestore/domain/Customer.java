package com.moviestore.domain;

import java.util.Collection;

public class Customer extends Person {

	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
