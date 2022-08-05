package com.moviestore.actions;

import java.util.Collection;
import java.util.Scanner;

import com.moviestore.domain.Movie;
import com.moviestore.exceptions.MovieStoreException;
import com.moviestore.util.Database;
import com.moviestore.util.Log;
import com.moviestore.util.Session;

public class FindMovie implements UserAction, SecureAction {

	public void execute() {
		try {
			if (!Session.isLoggedIn()) return;
			System.out.print("Title: ");
			Scanner scanner = new Scanner(System.in);
			String query = scanner.nextLine().trim();
			System.out.println();

			Collection<Movie> matches = this.searchByTitle(query);
			if (matches.size() == 0) {
				System.out.println("Sorry, no matches were found");
			} else {
				System.out.printf("%d matches were found:%n", matches.size());
				for (Movie movie : matches) {
					System.out.println(movie);
				}
			}
		} catch (Exception e) {
			Log.log(e);
		}
	}

	public Collection<Movie> searchByTitle(String query) throws MovieStoreException {
		Database database = new Database();
		return database.selectMovies(query);
	}

	public Movie searchById(int id) throws MovieStoreException {
		Database database = new Database();
		return database.selectMovieById(id);
	}

}
