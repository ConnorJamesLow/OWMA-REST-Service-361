/**
 * Connor Low
 * CST-
 * Oct 18, 2018
 * This is my own work.
 */
package api.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import api.AppConfig;
import api.models.PiData;

/**
 * @author speed
 *
 */
public class DataService {
	private static Connection connection;

	public static PiData getData() {
		PiData result = new PiData();
		try {
			// Connect to DB
			openConnection();

			// Select the last inserted data point
			String sql = "SELECT * FROM iotData \r\n"
					+ " WHERE id = (SELECT id FROM iotData ORDER BY id DESC LIMIT 1);";
			Statement command = connection.createStatement();

			// Execute Query
			ResultSet dbResult = command.executeQuery(sql);

			// Bind Data to result
			if (dbResult.next()) {
				result.setId(dbResult.getInt("id"));
				result.setTemperature(dbResult.getInt("temperature"));
				result.setDate(dbResult.getDate("date"));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} finally {

			try {
				closeConnection();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		// return result
		return result;
	}

	/**
	 * Builds a mysql connection using the DriverManager with
	 * <code>auto_commit = false</code>. The connection is assigned to the protected
	 * <code>connection</code> member variable.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private static void openConnection()
			throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		// Connect to DB
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(AppConfig.getConnectionString(), AppConfig.getUsername(),
				AppConfig.getPassword());

		// require manual commits
		connection.setAutoCommit(false);
	}

	/**
	 * Close the connection. Also commits any changes to database.
	 * 
	 * @throws SQLException
	 */
	private static void closeConnection() throws SQLException {
		connection.commit();
		connection.close();
	}
}
