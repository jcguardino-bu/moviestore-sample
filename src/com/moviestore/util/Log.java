package com.moviestore.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Log {

	public static void log(Object message) {
		PrintWriter writer = null;

		try {
			writer = new PrintWriter(new FileOutputStream(new File("log.txt"), true));

			if (message instanceof Exception) {
				writer.print("EXCEPTION: ");
				((Exception)message).printStackTrace(writer);
			} else {
				writer.println(message.toString());
			}
			writer.flush();
		} catch (Exception e) {
			// Eat this exception
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					// Eat this exception
				}
			}
		}
	}

}
