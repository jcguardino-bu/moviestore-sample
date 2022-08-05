package com.moviestore.domain;

import java.util.ArrayList;
import java.util.Collection;

import com.moviestore.actions.FindMovie;
import com.moviestore.util.Log;

public class ShoppingCart {

	private Collection<ShoppingCartItem> shoppingCartItems;

	public ShoppingCart() {
		this.shoppingCartItems = new ArrayList<ShoppingCartItem>();
	}

	public double computeTotal() {
		double total = 0.0;

		try {
			if (this.getShoppingCartItems() != null) {
				FindMovie find = new FindMovie();
				for (ShoppingCartItem item : this.getShoppingCartItems()) {
					total += (item.getQuantity() * find.searchById(item.getMovieId()).getCost());
				}
			}
		} catch (Exception e) {
			Log.log(e);
		}
		return total;
	}

	public void addItemToCart(ShoppingCartItem item) {
		this.shoppingCartItems.add(item);
	}

	public Collection<ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Collection<ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}
}
