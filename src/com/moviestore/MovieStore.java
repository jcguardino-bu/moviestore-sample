package com.moviestore;

import java.util.Scanner;

import com.moviestore.actions.*;
import com.moviestore.util.Log;
import com.moviestore.util.Session;

public class MovieStore {

	private static String[] options = { "Log in", "Search for movie", "Add movie to cart", "View cart", "Exit" };

	public static void main(String[] args) {
		try {
			int option = 0;
			do {
				do {
					option = displayMenu();
				} while (option == 0);

				System.out.println("----------");
				System.out.println(options[option - 1]);

				UserAction action = null;

				switch (option) {
					case 1:
						action = new Login();
						break;
					case 2:
						action = new FindMovie();
						break;
					case 3:
						action = new AddToCart();
						break;
					case 4:
						action = new ViewCart();
						break;
					case 5:
						System.out.println("Goodbye.");
						return;
					default:
						System.out.println("Unknown option");
						return;
				}

				if ((!(action instanceof SecureAction)) || Session.isLoggedIn()) {
					action.execute();
				}
				System.out.println();
				System.out.println("----------");
			} while (!options[option - 1].equals("Exit"));
		} catch (Exception e) {
			Log.log(e);
		}
	}

	private static int displayMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("MENU");

		for (int i = 0; i < options.length; i++) {
			System.out.printf("%d. %s%n", i + 1, options[i]);
		}

		System.out.println();
		System.out.print("Please select an option: ");

		if (!scanner.hasNextInt()) {
			System.out.println();
			System.out.println("Please try again.");
			return 0;
		}

		int selection = scanner.nextInt();

		if (selection <= 0 || selection > options.length) {
			System.out.println();
			System.out.println("Please try again.");
			return 0;
		}

		System.out.println();
		return selection;
	}

}
