package com.moviestore.actions;

import com.moviestore.domain.Movie;
import com.moviestore.domain.ShoppingCartItem;
import com.moviestore.util.Log;
import com.moviestore.util.Session;

public class ViewCart implements UserAction, SecureAction {

	public void execute() {
		try {
			if (Session.shoppingCart == null || Session.shoppingCart.getShoppingCartItems().size() == 0) {
				System.out.println("Shopping cart is empty.");
			} else {
				System.out.println("Your shopping cart:");
				FindMovie find = new FindMovie();
				for (ShoppingCartItem item : Session.shoppingCart.getShoppingCartItems()) {
					Movie movie = find.searchById(item.getMovieId());
					System.out.printf("%d unit(s) of %s = $%3.2f%n",
						item.getQuantity(), movie, item.getQuantity() * movie.getCost() );
				}
				System.out.printf("Grand total: $%.2f%n", Session.shoppingCart.computeTotal());
			}
		} catch (Exception e) {
			Log.log(e);
		}
	}
}
