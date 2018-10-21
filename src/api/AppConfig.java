/**
 * Connor Low
 * CST-
 * Oct 18, 2018
 * This is my own work.
 */
package api;

/**
 * @author speed
 *
 */
public class AppConfig {
	private static final String USERNAME = "CST361-user";
	private static final String PASSWORD = "ConnorLikesMemes";
	private static final String CONNECTION_STRING = "jdbc:mysql://brendanbrooks.net/cst361";

	public AppConfig() {
		super();
	}

	/**
	 * @return the username
	 */
	public static String getUsername() {
		return USERNAME;
	}

	/**
	 * @return the password
	 */
	public static String getPassword() {
		return PASSWORD;
	}

	/**
	 * @return the connectionString
	 */
	public static String getConnectionString() {
		return CONNECTION_STRING;
	}


}
