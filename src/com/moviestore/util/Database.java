package com.moviestore.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.moviestore.domain.Customer;
import com.moviestore.domain.Movie;
import com.moviestore.exceptions.MovieStoreException;

public class Database {

	private static final String URL = "jdbc:mysql://metcs520.mysql.database.azure.com:3306/samplestudent";
	private static final String USERNAME = "samplestudent@metcs520";
	private static final String PASSWORD = "metcs520";

	private Connection connection;

	public Customer selectCustomer(int customerId) throws MovieStoreException {
		ResultSet rs = null;

		try {
			this.connect();
			PreparedStatement pstmt = this.connection.prepareStatement("select * from customer where id = ?");
			pstmt.setInt(1, customerId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setLastName(rs.getString("LAST_NAME"));
				customer.setFirstName(rs.getString("FIRST_NAME"));
				customer.setCustomerId(customerId);
				return customer;
			}

			// No such customer found
			return null;
		} catch (Exception e) {
			throw new MovieStoreException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// Eat exception
			}
			this.disconnect();
		}
	}

	public Collection<Movie> selectMovies(String title) throws MovieStoreException {
		ResultSet rs = null;

		try {
			this.connect();
			PreparedStatement pstmt = this.connection.prepareStatement("select * from movie where title like ?");
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();
			Collection<Movie> movies = new ArrayList<Movie>();

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getInt("YEAR"));
				movie.setCost(rs.getDouble("COST"));
				movies.add(movie);
			}

			return movies;
		} catch (Exception e) {
			throw new MovieStoreException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// Eat exception
			}
			this.disconnect();
		}
	}

	public Movie selectMovieById(int movieId) throws MovieStoreException {
		ResultSet rs = null;

		try {
			this.connect();
			PreparedStatement pstmt = this.connection.prepareStatement("select * from movie where id = ?");
			pstmt.setInt(1, movieId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Movie movie = new Movie();
				movie.setMovieId(rs.getInt("ID"));
				movie.setTitle(rs.getString("TITLE"));
				movie.setYear(rs.getInt("YEAR"));
				movie.setCost(rs.getDouble("COST"));
				return movie;
			}
			return null;
		} catch (Exception e) {
			throw new MovieStoreException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				// Eat exception
			}
			this.disconnect();
		}
	}

	private void connect() throws SQLException {
		this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	private void disconnect() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (Exception e) {
				// Eat the exception
				e.printStackTrace();
			}
		}
	}

}
