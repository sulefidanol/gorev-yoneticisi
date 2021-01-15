package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import GorevYoneticisi.Config;
import model.Gorev;

public class RepositoryHelper {
	public static void execute(String query) {
		String connectionUrl = Config.connectionString;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);

			conn.prepareStatement(query).execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

		}
	}

}
