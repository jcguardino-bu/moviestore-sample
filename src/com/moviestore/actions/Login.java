package com.moviestore.actions;

import java.util.Scanner;

import com.moviestore.domain.Customer;
import com.moviestore.exceptions.MovieStoreException;
import com.moviestore.util.Database;
import com.moviestore.util.Log;
import com.moviestore.util.Session;

public class Login implements UserAction {

	public void execute() {
		try {
			this.login();
		} catch (Exception e) {
			Log.log(e);
			System.out.println();
		}
	}

	public Customer login() throws MovieStoreException {
		System.out.print("Customer ID: ");
		Scanner scanner = new Scanner(System.in);

		while (!scanner.hasNextInt()) {
			System.out.println("Please try again.");
			System.out.print("Customer ID: ");
			scanner.next();
		}

		int customerId = scanner.nextInt();
		Database database = new Database();
		Customer customer = database.selectCustomer(customerId);
		System.out.printf("Welcome, %s %s!", customer.getFirstName(), customer.getLastName());
		Log.log("Retrieved customer " + customerId);
		Session.customer = customer;
		return customer;
	}

}
