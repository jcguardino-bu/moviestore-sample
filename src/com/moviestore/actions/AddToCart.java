package com.moviestore.actions;

import java.util.Scanner;

import com.moviestore.domain.Movie;
import com.moviestore.domain.ShoppingCart;
import com.moviestore.domain.ShoppingCartItem;
import com.moviestore.util.Database;
import com.moviestore.util.Log;
import com.moviestore.util.Session;

public class AddToCart implements UserAction, SecureAction {

	public void execute() {
		try {
			if (!Session.isLoggedIn()) return;
			System.out.print("Movie ID: ");
			Scanner scanner = new Scanner(System.in);

			while (!scanner.hasNextInt()) {
				System.out.println("Please try again.");
				System.out.print("Movie ID: ");
				scanner.next();
			}

			int movieId = scanner.nextInt();
			System.out.println();

			FindMovie find = new FindMovie();
			Movie movie = find.searchById(movieId);

			if (movie == null) {
				System.out.println("No movie found by that ID.");
			} else {
				System.out.println("Selected movie: " + movie);
				System.out.print("Quantity: ");
				int quantity = scanner.nextInt();
				System.out.println();
				this.addToCart(movieId, quantity);
			}

		} catch (Exception e) {
			Log.log(e);
		}
	}

	private void addToCart(int movieId, int quantity) {
		if (Session.shoppingCart == null) {
			Session.shoppingCart = new ShoppingCart();
		}
		ShoppingCartItem item = new ShoppingCartItem(movieId, quantity);
		Session.shoppingCart.addItemToCart(item);
	}

}
