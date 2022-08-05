package com.moviestore.domain;

public class Movie {

	private int movieId;
	private String title;
	private int year;
	private double cost;

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String toString() {
		return String.format("%d: \"%s\" (%d): $%2.2f", this.getMovieId(), this.getTitle(), this.getYear(), this.getCost());
	}
}
