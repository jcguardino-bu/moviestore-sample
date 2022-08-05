package com.moviestore.util;

import com.moviestore.domain.Customer;
import com.moviestore.domain.ShoppingCart;

public class Session {

	public static Customer customer = null;
	public static ShoppingCart shoppingCart = null;

	public static boolean isLoggedIn() {
		boolean loggedIn = customer != null;
		if (!loggedIn) {
			System.out.println("Please log in first.");
		}
		return loggedIn;
	}
}
