package com.moviestore.domain;

public class ShoppingCartItem {

	private int movieId;
	private int quantity;

	public ShoppingCartItem(int movieId, int quantity) {
		this.setMovieId(movieId);
		this.setQuantity(quantity);
	}

	public int getMovieId() {
		return this.movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
